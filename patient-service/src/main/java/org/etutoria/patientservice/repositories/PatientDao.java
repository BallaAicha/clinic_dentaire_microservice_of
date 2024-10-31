package org.etutoria.patientservice.repositories;
import org.etutoria.patientservice.entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientDao extends MongoRepository<Patient, String> {
}