package org.etutoria.facture.repositories;


import org.etutoria.facture.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {
}
