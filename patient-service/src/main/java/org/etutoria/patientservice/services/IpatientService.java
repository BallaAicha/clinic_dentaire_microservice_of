package org.etutoria.patientservice.services;

import org.etutoria.patientservice.dtos.PatientDto;

import java.util.List;

public interface IpatientService {
    List<PatientDto> listAllPatients();
}
