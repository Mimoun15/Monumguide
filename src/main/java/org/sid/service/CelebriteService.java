package org.sid.service;

import org.sid.entity.Celebrite;
import org.sid.entity.Monument;
import org.sid.dao.CelebriteRepository;
import org.sid.dao.MonumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CelebriteService implements ICelebriteService {

	@Autowired
	private CelebriteRepository celebriteRepository;
	@Autowired
	private MonumentRepository monumentRepository;

	@Override
	public List<Celebrite> findCelebriteByNom(String nom) {
		return celebriteRepository.findCelebriteByNom(nom);
	}

	@Override
	public Celebrite addCelebrite(Celebrite c) {
		celebriteRepository.save(c);
		return c;
	}

	@Override
	public Celebrite update(Celebrite c) {
		return null;
	}

	@Override
	public Celebrite save(Celebrite c) {
		return celebriteRepository.save(c);
	}

	@Override
	public void deleteCelebrite(Integer numCelebrite) {
		celebriteRepository.deleteById(numCelebrite);
	}

	@Override
	public Collection<Celebrite> getCelebriteParMonument(String codeMonument) {
		return monumentRepository.getOne(codeMonument).getCelebrites();
	}

	@Override
	public Collection<Celebrite> getAllCelebrites() {
		return celebriteRepository.findAll();
	}

	@Override
	public Page<Celebrite> getAllCelebritesParPage(int page, int size) {
		// TODO Auto-generated method stub
		return celebriteRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public Celebrite getCelebriteParId(Integer id) {
		return celebriteRepository.findById(id).get();
	}

	@Override
	public void addCelebriteToMonument(Integer numCelebrite, String codeM) {
		Monument monument = monumentRepository.getOne(codeM);
		Celebrite celebrite = celebriteRepository.getOne(numCelebrite);
		celebrite.getMonuments().add(monument);
		monument.getCelebrites().add(celebrite);
	}
}
