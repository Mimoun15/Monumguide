package org.sid.service;

import org.sid.entity.Lieu;
import org.sid.dao.LieuRepository;
import org.sid.service.ILieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LieuService implements ILieuService {

	@Autowired
	LieuRepository lieuRepository;

	@Override
	public Lieu updateLieu(Lieu l) {
		lieuRepository.save(l);
		return l;
	}

	@Override
	public Lieu saveLieu(Lieu l) {
		return lieuRepository.save(l);
	}

	@Override
	public void deleteLieuById(String id) {
		lieuRepository.deleteById(id);
	}

	@Override
	public Lieu getLieu(String id) {
		return lieuRepository.findById(id).get();
	}

	@Override
	public List<Lieu> getAllLieux() {
		return lieuRepository.findAll();
	}

	@Override
	public List<Lieu> findByCodeInsee(String CodeInsee) {
		return lieuRepository.findByCodeInsee(CodeInsee);
	}
}
