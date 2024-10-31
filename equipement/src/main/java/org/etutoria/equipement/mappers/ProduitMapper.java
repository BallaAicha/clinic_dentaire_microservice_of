package org.etutoria.equipement.mappers;

import org.etutoria.equipement.dtos.ProduitDto;
import org.etutoria.equipement.entities.Produit;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProduitMapper {

    public ProduitMapper() {
    }
    public ProduitDto fromProduit(Produit produit) {
        if (produit == null) {
            return null;
        }
        ProduitDto produitDto = new ProduitDto();
        BeanUtils.copyProperties(produit, produitDto);
        return produitDto;
    }

    public Produit fromProduitDto(ProduitDto produitDto) {
        if (produitDto == null) {
            return null;
        }
        Produit produit = new Produit();
        BeanUtils.copyProperties(produitDto, produit);
        return produit;
    }
}