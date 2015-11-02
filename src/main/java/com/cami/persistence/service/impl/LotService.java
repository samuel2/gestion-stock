/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.service.impl;

import com.cami.persistence.dao.IEntreeDao;
import com.cami.persistence.dao.IFournitureDao;
import com.cami.persistence.dao.ILotDao;
import com.cami.persistence.model.Entree;
import com.cami.persistence.model.Fourniture;
import com.cami.persistence.model.Lot;
import com.cami.persistence.service.ILotService;
import com.cami.persistence.service.common.AbstractService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Service("lotService")
public class LotService extends AbstractService<Lot> implements ILotService {

    @Autowired
    private ILotDao iLotDao;

    @Autowired
    private IEntreeDao iEntreeDao;

    @Autowired
    private IFournitureDao iFournitureDao;

    @Override
    protected PagingAndSortingRepository<Lot, Long> getDao() {
        return iLotDao;
    }

    @Override
    public Lot create(Lot entity) {
        Entree entree = iEntreeDao.findOne(entity.getEntree().getId());
        Fourniture fourniture = iFournitureDao.findOne(entity.getFourniture().getId());
        entity.setEntree(entree);
        entity.setFourniture(fourniture);
        return iLotDao.save(entity);
    }

    @Override
    public Lot update(Lot entity) {
        Lot lotToUpdate = iLotDao.findOne(entity.getId());
        Entree entree = iEntreeDao.findOne(entity.getEntree().getId());
        Fourniture fourniture = iFournitureDao.findOne(entity.getFourniture().getId());
        lotToUpdate.setDateEntree(entity.getDateEntree());
        lotToUpdate.setNumero(entity.getNumero());
        lotToUpdate.setPrixUnitaire(entity.getPrixUnitaire());
        lotToUpdate.setPrixVenteUnitaire(entity.getPrixVenteUnitaire());
        lotToUpdate.setQuantite(entity.getQuantite());
        lotToUpdate.setTotalMontant(entity.getTotalMontant());
        lotToUpdate.setEtat(entity.getEtat());
        lotToUpdate.setEntree(entree);
        lotToUpdate.setFourniture(fourniture);
        return iLotDao.save(lotToUpdate);
    }

    @Override
    public void delete(Lot entity) {
        iLotDao.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        iLotDao.delete(entityId);
    }

    @Override
    public void disableEntity(Lot entity) {

        if (entity.isDeleted()) {
            entity.setDeleted(false);
        } else {
            entity.setDeleted(true);
        }
    }

    @Override
    public List<Lot> findByEntree(Entree entree) {
        return iLotDao.findByEntree(entree);
    }

    @Override
    public List<Lot> findByFourniture(Fourniture fourniture) {
        return iLotDao.findByFourniture(fourniture);
    }

    @Override
    public Page<Lot> searchLots(String numero, Date dateEntree, float prixUnitaire, float prixVenteUnitaire, int quantite, int totalMontant, String etat, boolean deleted, int page, Integer size) {
        return iLotDao.searchLots('%' + numero + '%', dateEntree, prixUnitaire, prixVenteUnitaire, quantite, totalMontant, '%' + etat + '%', deleted, new PageRequest(page, size));
    }

}
