package org.etutoria.equipement.services;



import org.etutoria.equipement.dtos.ProduitDto;

import java.util.List;

public interface IProduitService {

     List<ProduitDto> getProduits();
     ProduitDto createProduit(ProduitDto produitDto);



}
