package org.sid.service;

import org.sid.entity.Departement;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IDepartementService {
	Departement saveDepartement(Departement d);

	Departement updateDepartement(Departement d);

	void deleteDepartementById(String id);

	Departement getDepartement(String id);

	List<Departement> getAllDepartements();

}
