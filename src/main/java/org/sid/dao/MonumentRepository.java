package org.sid.dao;

import org.sid.entity.Monument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentRepository extends JpaRepository<Monument, String> {

}
