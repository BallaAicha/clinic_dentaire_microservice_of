package org.etutoria.rendezvousservice.repositories;


import org.etutoria.rendezvousservice.entities.RV_Soins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RV_SoinsDao extends JpaRepository<RV_Soins, Long> {
}
