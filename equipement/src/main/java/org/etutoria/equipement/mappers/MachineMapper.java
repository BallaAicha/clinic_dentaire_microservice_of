package org.etutoria.equipement.mappers;

import org.etutoria.equipement.dtos.MachineDto;
import org.etutoria.equipement.entities.Machine;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MachineMapper {

    public MachineDto fromMachine(Machine machine) {
        if (machine == null) {
            return null;
        }
        MachineDto machineDto = new MachineDto();
        BeanUtils.copyProperties(machine, machineDto);
        return machineDto;
    }

    public Machine fromMachineDto(MachineDto machineDto) {
        if (machineDto == null) {
            return null;
        }
        Machine machine = new Machine();
        BeanUtils.copyProperties(machineDto, machine);
        return machine;
    }
}