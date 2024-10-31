package org.etutoria.patientservice.services.impl;
import org.etutoria.patientservice.dtos.DossierDto;
import org.etutoria.patientservice.mappers.DossierMapper;
import org.etutoria.patientservice.repositories.DossierDao;
import org.etutoria.patientservice.services.IDossierPatient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DossierPatientImpl implements IDossierPatient {
    private final DossierDao dossierDao;
    private final DossierMapper dossierMapper;

    public DossierPatientImpl(DossierDao dossierDao, DossierMapper dossierMapper) {
        this.dossierDao = dossierDao;
        this.dossierMapper = dossierMapper;
    }
    @Override
    public List<DossierDto> listAllDossiers() {
        return dossierDao.findAll().stream().map(dossierMapper::fromDossier).collect(Collectors.toList());
    }
}
