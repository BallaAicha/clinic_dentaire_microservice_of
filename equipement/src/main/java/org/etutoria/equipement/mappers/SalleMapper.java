package org.etutoria.equipement.mappers;


import org.etutoria.equipement.dtos.SalleDto;
import org.etutoria.equipement.entities.Salle;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SalleMapper {
    public SalleMapper() {

    }
    public SalleDto fromSalle(Salle salle) {
        if (salle == null) {
            return null;
        }
        SalleDto salleDto = new SalleDto();
        BeanUtils.copyProperties(salle, salleDto);
        return salleDto;
    }
    public Salle fromSalleDto(SalleDto salleDto) {
        if (salleDto == null) {
            return null;
        }
        Salle salle = new Salle();
        BeanUtils.copyProperties(salleDto, salle);
        return salle;
    }
}