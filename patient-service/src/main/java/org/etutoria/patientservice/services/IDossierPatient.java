package org.etutoria.patientservice.services;

import org.etutoria.patientservice.dtos.DossierDto;

import java.util.List;

public interface IDossierPatient {
    List<DossierDto> listAllDossiers();
}
