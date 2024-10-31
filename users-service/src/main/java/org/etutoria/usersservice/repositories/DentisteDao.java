package org.etutoria.usersservice.repositories;

import org.etutoria.usersservice.entities.Dentiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentisteDao extends JpaRepository<Dentiste, Long> {
}
