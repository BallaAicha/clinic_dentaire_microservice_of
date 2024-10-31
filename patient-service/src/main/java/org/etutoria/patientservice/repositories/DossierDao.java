package org.etutoria.patientservice.repositories;

import org.etutoria.patientservice.entities.Dossier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DossierDao extends MongoRepository<Dossier, String> {
}