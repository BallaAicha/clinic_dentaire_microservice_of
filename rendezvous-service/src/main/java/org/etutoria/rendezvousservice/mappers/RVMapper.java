package org.etutoria.rendezvousservice.mappers;

import org.etutoria.rendezvousservice.dtos.RVDto;
import org.etutoria.rendezvousservice.entities.RV;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RVMapper {

    @Mapping(source = "dateHeure", target = "dateHeure")
    RVDto toDto(RV rv);
    @Mapping(source = "dateHeure", target = "dateHeure")
    RV toEntity(RVDto rvDto);
}
