package org.etutoria.equipement.repositories;


import org.etutoria.equipement.entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineDao extends JpaRepository<Machine, Long> {
}
