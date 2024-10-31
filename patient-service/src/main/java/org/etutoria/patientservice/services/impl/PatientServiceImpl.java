package org.etutoria.patientservice.services.impl;
import org.etutoria.patientservice.dtos.PatientDto;
import org.etutoria.patientservice.mappers.PatientMapper;
import org.etutoria.patientservice.repositories.PatientDao;
import org.etutoria.patientservice.services.IpatientService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements IpatientService {
    private final PatientDao patientDao;
    private final PatientMapper patientMapper;

    public PatientServiceImpl(PatientDao patientDao, PatientMapper patientMapper) {
        this.patientDao = patientDao;
        this.patientMapper = patientMapper;
    }

    @Override
    public List<PatientDto> listAllPatients() {
        return patientDao.findAll().stream().map(patientMapper::fromPatient).collect(Collectors.toList());
    }

}
