package org.etutoria.equipement.services.impl;

import org.etutoria.equipement.dtos.ProduitDto;
import org.etutoria.equipement.mappers.ProduitMapper;
import org.etutoria.equipement.repositories.ProduitDao;
import org.etutoria.equipement.services.IProduitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements IProduitService {

    private final ProduitDao produitDao;
    final ProduitMapper produitMapper;

    public ProduitServiceImpl(ProduitDao produitDao, ProduitMapper produitMapper) {
        this.produitDao = produitDao;
        this.produitMapper = produitMapper;
    }

    @Override
    public List<ProduitDto> getProduits() {
        return produitDao.findAll().stream().map(produitMapper::fromProduit).collect(Collectors.toList());
    }

    @Override
    public ProduitDto createProduit(ProduitDto produitDto) {
        return produitMapper.fromProduit(produitDao.save(produitMapper.fromProduitDto(produitDto)));
    }
}
