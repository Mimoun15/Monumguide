package org.sid.web;

import org.sid.dao.MonumentRepository;

import org.sid.entity.Celebrite;
import org.sid.entity.Lieu;
import org.sid.entity.Monument;
import org.sid.service.ICelebriteService;
import org.sid.service.ILieuService;
import org.sid.service.IMonumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Controller
public class MonumentController {

	// injection de dependances
	@Autowired
	private IMonumentService monumentService;
	@Autowired
	private MonumentRepository monumentRepository;
	@Autowired
	private ILieuService lieuService;

	@Autowired
	private ICelebriteService celebriteService;

	@Secured(value = { "ROLE_ADMIN", "ROLE_USER" })
	@RequestMapping(value = "/allMonuments", method = RequestMethod.GET)
	public String allMonuments(Model modelMap,

			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size) {

		Page<Monument> mnmts = monumentService.getAllMonumentsParPage(page, size);
		modelMap.addAttribute("monuments", mnmts);
		modelMap.addAttribute("pages", new int[mnmts.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "Monument/allMonuments";

	}

	// List<Monument> monuments = monumentService.getAllMonuments();
	// modelMap.addAttribute("monuments",monuments);
	// return "Monuments/allMonuments";// la vue

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping("/editMonument")
	public String updateMonument(@RequestParam("id") String id, ModelMap modelMap) {
		Monument m = monumentService.getMonument(id);
		Collection<Celebrite> celebrites = celebriteService.getAllCelebrites();
		List<Lieu> lieux = lieuService.getAllLieux();
		modelMap.addAttribute("monument", m);
		modelMap.addAttribute("lieux", lieux);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("celebrites", celebrites);
		return "Monuments/monumentForm";
	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping("/addMonument")
	public String addMonument(ModelMap modelMap) {
		Collection<Celebrite> celebrites = celebriteService.getAllCelebrites();
		List<Lieu> lieux = lieuService.getAllLieux();
		modelMap.addAttribute("lieux", lieux);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("celebrites", celebrites);
		return "Monuments/monumentForm";
	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping("/saveMonument")
	public String saveMonument(@ModelAttribute("monument") Monument m, ModelMap modelMap) {
		monumentService.saveMonument(m);
		List<Monument> monuments = monumentService.getAllMonuments();
		modelMap.addAttribute("monuments", monuments);
		return "Monuments/allMonuments";
	}

	@Secured(value = { "ROLE_ADMIN" })

	@RequestMapping("/deleteMonument")
	public String deleMonument(@RequestParam("id") String id, ModelMap modelMap) {
		monumentService.deleteMonumentById(id);
		List<Monument> monuments = monumentService.getAllMonuments();
		modelMap.addAttribute("monuments", monuments);
		return "Monuments/allmonuments";
	}

	@RequestMapping("/distance")
	public String distance(ModelMap modelMap) {
		List<Monument> monuments = monumentService.getAllMonuments();
		modelMap.addAttribute("monuments", monuments);
		return "Traitements/distance";
	}

	@RequestMapping("/calculeDistance")
	public String calculeDistance(ModelMap modelMap, String codeM1, String codeM2) {
		float distance = monumentService.distance(codeM1, codeM2);
		Monument m1 = monumentService.getMonument(codeM1);
		Monument m2 = monumentService.getMonument(codeM2);
		modelMap.addAttribute("monument1", m1);
		modelMap.addAttribute("monument2", m2);
		modelMap.addAttribute("distance", distance);
		List<Monument> monuments = monumentService.getAllMonuments();
		modelMap.addAttribute("monuments", monuments);
		modelMap.addAttribute("map", true);
		return "Traitements/distance";
	}

}
