package org.sid.dao;

import org.sid.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, String> {

}
