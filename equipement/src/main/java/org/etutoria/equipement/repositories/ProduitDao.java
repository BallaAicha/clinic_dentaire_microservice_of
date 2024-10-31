package org.etutoria.equipement.repositories;


import org.etutoria.equipement.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitDao extends JpaRepository<Produit, Long> {
}
