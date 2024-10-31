package org.etutoria.rendezvousservice.repositories;


import org.etutoria.rendezvousservice.entities.RV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RVDao extends JpaRepository<RV, Long> {
}
