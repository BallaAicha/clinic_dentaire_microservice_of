package org.etutoria.facture.services;

import org.etutoria.facture.dtos.FactureDto;

import java.util.List;

public interface IFactureService {
    List<FactureDto> listFactures();
    FactureDto createFacture(FactureDto factureDto);
    FactureDto getFacture(Long factureId);
}
