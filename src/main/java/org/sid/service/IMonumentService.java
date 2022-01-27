package org.sid.service;

import org.sid.entity.Monument;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IMonumentService {

	Monument saveMonument(Monument m);

	Monument updateMonument(Monument m);

	void deleteMonumentById(String id);

	Monument getMonument(String id);

	List<Monument> getAllMonuments();

	Page<Monument> getAllMonumentsParPage(int page, int size);

	float distance(String codeM1, String codeM2);
}
