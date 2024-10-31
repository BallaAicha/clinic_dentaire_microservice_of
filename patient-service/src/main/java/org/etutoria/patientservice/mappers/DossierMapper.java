package org.etutoria.patientservice.mappers;

import org.etutoria.patientservice.dtos.DossierDto;
import org.etutoria.patientservice.entities.Dossier;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class DossierMapper {
    private final PatientMapper patientMapper;

    public DossierMapper(@Lazy PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    public DossierDto fromDossier(Dossier dossier) {
        if (dossier == null) {
            return null;
        }
        DossierDto dossierDto = new DossierDto();
        BeanUtils.copyProperties(dossier, dossierDto);
        dossierDto.setPatient(patientMapper.fromPatient(dossier.getPatient()));
        return dossierDto;
    }

    public Dossier fromDossierDto(DossierDto dossierDto) {
        if (dossierDto == null) {
            return null;
        }
        Dossier dossier = new Dossier();
        BeanUtils.copyProperties(dossierDto, dossier);
        dossier.setPatient(patientMapper.fromPatientDto(dossierDto.getPatient()));
        return dossier;
    }
}