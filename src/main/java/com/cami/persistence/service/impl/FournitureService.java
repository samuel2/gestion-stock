/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.service.impl;

import com.cami.persistence.dao.ICategorieDao;
import com.cami.persistence.dao.IFournitureDao;
import com.cami.persistence.model.Fourniture;
import com.cami.persistence.service.IFournitureService;
import com.cami.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Service("fournitureService")
public class FournitureService extends AbstractService<Fourniture> implements IFournitureService {

    @Autowired
    private IFournitureDao iFournitureDao;

    @Autowired
    private ICategorieDao iCategorieDao;

    @Override
    protected PagingAndSortingRepository<Fourniture, Long> getDao() {
        return iFournitureDao;
    }

    @Override
    public Fourniture create(Fourniture entity) {
        entity.setCategorie(iCategorieDao.findOne(entity.getCategorie().getId()));
        return iFournitureDao.save(entity);
    }

    @Override
    public Fourniture update(Fourniture entity) {
        Fourniture fournitureToUpdate = iFournitureDao.findOne(entity.getId());
        fournitureToUpdate.setReference(entity.getReference());
        fournitureToUpdate.setDesignation(entity.getDesignation());
        fournitureToUpdate.setQuantite(entity.getQuantite());
        fournitureToUpdate.setSeuil(entity.getSeuil());
        fournitureToUpdate.setCategorie(iCategorieDao.findOne(entity.getCategorie().getId()));
        return iFournitureDao.save(fournitureToUpdate);
    }

    @Override
    public void delete(Fourniture entity) {
        iFournitureDao.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        iFournitureDao.delete(entityId);
    }

    @Override
    public void disableEntity(Fourniture entity) {

        if (entity.isDeleted()) {
            entity.setDeleted(false);
        } else {
            entity.setDeleted(true);
        }
    }

    @Override
    public Page<Fourniture> findPaginated(String reference, String designation, int quantite, int seuil, boolean deleted, int nombrePage, Integer size) {
        return iFournitureDao.searchFournitures('%' + reference + '%', '%' + designation + '%', '%' + quantite + '%', '%' + seuil + '%', deleted, new PageRequest(nombrePage, size));
    }

}
