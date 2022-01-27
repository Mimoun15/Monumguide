package org.sid.web;

import org.sid.Exceptions.FloatErrorException;
import org.sid.entity.Departement;

import org.sid.entity.Lieu;
import org.sid.service.IDepartementService;
import org.sid.service.ILieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Controller
public class LieuController {

	@Autowired
	private ILieuService lieuService;
	@Autowired
	private IDepartementService departementService;

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/allLieux")
	public String allLieux(ModelMap modelMap) {
		List<Lieu> lieux = lieuService.getAllLieux();
		modelMap.addAttribute("lieux", lieux);
		return "Lieu/allLieux";
	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping("/editLieu")
	public String updatelieu(@RequestParam("id") String id, ModelMap modelMap) {
		Lieu l = lieuService.getLieu(id);
		List<Departement> departements = departementService.getAllDepartements();
		modelMap.addAttribute("lieu", l);
		modelMap.addAttribute("departements", departements);
		modelMap.addAttribute("mode", "edit");
		return "Lieu/lieuForm";
	}

	@Secured(value = { "ROLE_ADMIN" })

	@GetMapping("/addLieu")
	public String addlieu(ModelMap modelMap) {
		List<Departement> departements = departementService.getAllDepartements();
		modelMap.addAttribute("departements", departements);
		modelMap.addAttribute("mode", "new");
		return "Lieu/lieuForm";
	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping("/saveLieu")
	public String savelieu(@ModelAttribute("lieu") Lieu lieu, ModelMap modelMap) {
		Lieu savelieu = lieuService.saveLieu(lieu);
		Collection<Lieu> lieux = lieuService.getAllLieux();
		modelMap.addAttribute("lieux", lieux);
		return "lieu/allLieux";

	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping("/deleteLieu")
	public String deleteLieu(@RequestParam("id") String id, ModelMap modelMap) {
		lieuService.deleteLieuById(id);
		Collection<Lieu> lieux = lieuService.getAllLieux();
		modelMap.addAttribute("lieux", lieux);
		return "Lieu/allLieux";
	}

}
