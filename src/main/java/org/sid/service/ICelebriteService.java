package org.sid.service;

import org.sid.entity.Celebrite;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ICelebriteService {

	public List<Celebrite> findCelebriteByNom(String nom);

	// Celebrite par monument
	public Collection<Celebrite> getCelebriteParMonument(String codeMonument);

	// ALL
	public Collection<Celebrite> getAllCelebrites();

	public Celebrite addCelebrite(Celebrite c);

	// Ajouter Celebrite a un monument
	public void addCelebriteToMonument(Integer numCelebrite, String codeM);

	// supprimer
	public void deleteCelebrite(Integer numCelebrite);

	// Page
	Page<Celebrite> getAllCelebritesParPage(int page, int size);

	// mettre a jour
	Celebrite update(Celebrite c);

	Celebrite save(Celebrite c);

	Celebrite getCelebriteParId(Integer id);
}
