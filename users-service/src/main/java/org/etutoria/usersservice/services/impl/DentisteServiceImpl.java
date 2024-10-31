package org.etutoria.usersservice.services.impl;
import lombok.AllArgsConstructor;
import org.etutoria.usersservice.dtos.DentisteDto;
import org.etutoria.usersservice.entities.Dentiste;
import org.etutoria.usersservice.entities.User;
import org.etutoria.usersservice.mappers.DentisteMapper;
import org.etutoria.usersservice.repositories.DentisteDao;
import org.etutoria.usersservice.repositories.UserDao;
import org.etutoria.usersservice.salle.SalleClient;
import org.etutoria.usersservice.services.IDentisteService;
import org.etutoria.usersservice.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DentisteServiceImpl implements IDentisteService {
    private final DentisteDao dentisteDao;
    private final UserDao userDao;
    private final DentisteMapper dentisteMapper;
    private final SalleClient salleClient;
    private final UserService userService;

    @Override
    public DentisteDto createDentiste(DentisteDto dentisteDto) {
        User user = userService.createUser(dentisteDto.getUser().getEmail(), dentisteDto.getUser().getPassword());
        userService.assignRoleToUser(user.getEmail(), "DENTISTE");
        Dentiste dentiste = dentisteMapper.toEntity(dentisteDto);
        dentiste.setUser(user);
        salleClient.listAllSalles().stream()
                .filter(s -> s.getSalleId().equals(dentisteDto.getSalle().getSalleId()))// Filter the salle with the given salleId
                .findFirst()// Find the first salle that matches the given salleId
                .ifPresentOrElse(
                        salle -> dentiste.setSalleId(salle.getSalleId()),
                        () -> {
                            throw new RuntimeException("Salle not found");
                        }
                );
        Dentiste savedDentiste = dentisteDao.save(dentiste);
        return dentisteMapper.toDto(savedDentiste);
    }

    @Override
    public List<DentisteDto> getAllDentistes() {
        return dentisteDao.findAll().stream().map(dentisteMapper::toDto).toList();
    }
}