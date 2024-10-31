package org.etutoria.equipement.repositories;


import org.etutoria.equipement.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleDao extends JpaRepository<Salle, Long> {
}
