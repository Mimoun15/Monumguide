package org.sid.service;

import org.sid.entity.Departement;

import org.sid.dao.DepartementRepository;
import org.sid.service.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService implements IDepartementService {

	@Autowired
	DepartementRepository departementRepository;

	@Override
	public Departement saveDepartement(Departement d) {
		return departementRepository.save(d);
	}

	@Override
	public Departement updateDepartement(Departement d) {
		return departementRepository.save(d);
	}

	@Override
	public void deleteDepartementById(String id) {
		departementRepository.deleteById(id);
	}

	@Override
	public Departement getDepartement(String id) {
		return departementRepository.findById(id).get();
	}

	@Override
	public List<Departement> getAllDepartements() {
		return departementRepository.findAll();
	}
}
