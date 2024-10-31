package org.etutoria.usersservice.mappers;
import org.etutoria.usersservice.dtos.DentisteDto;
import org.etutoria.usersservice.entities.Dentiste;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DentisteMapper {
    @Mapping(source = "user.email", target = "user.email")
    @Mapping(source = "salleId", target = "salle.salleId")
    @Mapping(source = "nomSalle", target = "salle.nom")
    DentisteDto toDto(Dentiste dentiste);

    @Mapping(source = "user.email", target = "user.email")
    @Mapping(source = "salle.salleId", target = "salleId")
    @Mapping(source = "salle.nom", target = "nomSalle")
    Dentiste toEntity(DentisteDto dentisteDto);
}