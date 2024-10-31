package org.etutoria.patientservice.mappers;

import org.etutoria.patientservice.dtos.PatientDto;
import org.etutoria.patientservice.entities.Patient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public PatientMapper() {
    }

    public PatientDto fromPatient(Patient patient) {
        if (patient == null) {
            return null;
        }
        PatientDto patientDto = new PatientDto();
        BeanUtils.copyProperties(patient, patientDto);
        return patientDto;
    }

    public Patient fromPatientDto(PatientDto patientDto) {
        if (patientDto == null) {
            return null;
        }
        Patient patient = new Patient();
        BeanUtils.copyProperties(patientDto, patient);
        return patient;
    }
}