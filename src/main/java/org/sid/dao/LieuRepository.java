package org.sid.dao;

import org.sid.entity.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LieuRepository extends JpaRepository<Lieu, String> {

	List<Lieu> findByCodeInsee(String CodeInsee);
}
