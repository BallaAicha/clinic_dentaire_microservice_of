package org.etutoria.usersservice.services;


import org.etutoria.usersservice.dtos.DentisteDto;

import java.util.List;

public interface IDentisteService {
  DentisteDto createDentiste(DentisteDto dentisteDto);
  List<DentisteDto> getAllDentistes();

}
