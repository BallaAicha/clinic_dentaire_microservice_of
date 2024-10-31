package org.etutoria.soinsservice.repositories;

import org.etutoria.soinsservice.entities.Soins;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SoinsDao extends JpaRepository<Soins, Long> {
}
