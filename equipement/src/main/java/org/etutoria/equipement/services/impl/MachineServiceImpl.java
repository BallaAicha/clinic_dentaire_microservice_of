package org.etutoria.equipement.services.impl;

import org.etutoria.equipement.dtos.MachineDto;
import org.etutoria.equipement.mappers.MachineMapper;
import org.etutoria.equipement.repositories.MachineDao;
import org.etutoria.equipement.services.IMachineService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MachineServiceImpl implements IMachineService {
    private final MachineDao machineDao;
    private final MachineMapper machineMapper;

    public MachineServiceImpl(MachineDao machineDao, MachineMapper machineMapper) {
        this.machineDao = machineDao;
        this.machineMapper = machineMapper;
    }

    @Override
    public List<MachineDto> listMachines() {
        return machineDao.findAll().stream().map(machineMapper::fromMachine).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public MachineDto createMachine(MachineDto machineDto) {
        return machineMapper.fromMachine(machineDao.save(machineMapper.fromMachineDto(machineDto)));
    }
}
