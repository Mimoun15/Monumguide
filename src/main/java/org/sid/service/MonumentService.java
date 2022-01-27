package org.sid.service;

import org.sid.entity.Monument;
import org.sid.dao.MonumentRepository;
import org.sid.service.IMonumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonumentService implements IMonumentService {

	@Autowired
	private MonumentRepository monumentRepository;

	@Override
	public Monument saveMonument(Monument m) {
		return monumentRepository.save(m);
	}

	@Override
	public Monument updateMonument(Monument m) {
		return monumentRepository.save(m);
	}

	@Override
	public void deleteMonumentById(String id) {
		monumentRepository.deleteById(id);
	}

	@Override
	public Monument getMonument(String id) {
		return monumentRepository.findById(id).get();
	}

	@Override
	public List<Monument> getAllMonuments() {
		return monumentRepository.findAll();
	}

	@Override
	public float distance(String codeM1, String codeM2) {
		// le radus de la terre
		final int R = 6371;
		Monument m1 = monumentRepository.findById(codeM1).get();
		Monument m2 = monumentRepository.findById(codeM2).get();
		float latDistance = (float) Math.toRadians(m2.getLatitude() - m1.getLatitude());
		float lonDistance = (float) Math.toRadians(m2.getLongitude() - m1.getLongitude());
		float a = (float) (Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(m1.getLatitude())) * Math.cos(Math.toRadians(m2.getLatitude()))
						* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2));
		float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
		// convertir pour les mettre
		float distance = R * c * 1000;
		distance = (float) Math.pow(distance, 2);
		return (float) (Math.sqrt(distance) / 1000);

	}

	@Override
	public Page<Monument> getAllMonumentsParPage(int page, int size) {

		return monumentRepository.findAll(PageRequest.of(page, size));
	}

}
