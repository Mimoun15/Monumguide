package org.sid.dao;

import org.sid.entity.Celebrite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CelebriteRepository extends JpaRepository<Celebrite, Integer> {

	List<Celebrite> findCelebriteByNom(String nom);

}
