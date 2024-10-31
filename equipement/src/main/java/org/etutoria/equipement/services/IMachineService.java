package org.etutoria.equipement.services;



import org.etutoria.equipement.dtos.MachineDto;

import java.util.List;

public interface IMachineService {
    List<MachineDto> listMachines();
    MachineDto createMachine(MachineDto machineDto);
}
