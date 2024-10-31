package org.etutoria.facture.mappers;
import org.etutoria.facture.dtos.FactureDto;
import org.etutoria.facture.entities.Facture;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FactureMapper {
    public FactureMapper() {
    }
    public FactureDto fromFacture(Facture facture) {
        if (facture == null) {
            return null;
        }
        FactureDto factureDto = new FactureDto();
        BeanUtils.copyProperties(facture, factureDto);
        return factureDto;
    }

    public Facture fromFactureDto(FactureDto factureDto) {
        if (factureDto == null) {
            return null;
        }
        Facture facture = new Facture();
        BeanUtils.copyProperties(factureDto, facture);
        return facture;
    }
}