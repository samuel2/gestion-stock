/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.service.impl;

import com.cami.persistence.dao.IDepartementDao;
import com.cami.persistence.dao.IEntreeDao;
import com.cami.persistence.dao.IUserDao;
import com.cami.persistence.model.Departement;
import com.cami.persistence.model.Entree;
import com.cami.persistence.model.User;
import com.cami.persistence.service.IEntreeService;
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
@Service("entreeService")
public class EntreeService extends AbstractService<Entree> implements IEntreeService {

    @Autowired
    private IEntreeDao iEntreeDao;

    @Autowired
    private IDepartementDao iDepartementDao;

    @Autowired
    private IUserDao iUserDao;

    @Override
    protected PagingAndSortingRepository<Entree, Long> getDao() {
        return iEntreeDao;
    }

    @Override
    public Entree create(Entree entity) {
        entity.setDepartement(iDepartementDao.findOne(entity.getDepartement().getId()));
        entity.setUser(iUserDao.findOne(entity.getUser().getId()));
        return iEntreeDao.save(entity);
    }

    @Override
    public Entree update(Entree entity) {
        Entree entreeToUpdate = iEntreeDao.findOne(entity.getId());
        entreeToUpdate.setNumero(entity.getNumero());
        entreeToUpdate.setDateOperation(entity.getDateOperation());
        entreeToUpdate.setObservation(entity.getObservation());
        entreeToUpdate.setDepartement(iDepartementDao.findOne(entity.getDepartement().getId()));
        entreeToUpdate.setUser(iUserDao.findOne(entity.getUser().getId()));
        return iEntreeDao.save(entreeToUpdate);
    }

    @Override
    public void delete(Entree entity) {
        iEntreeDao.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        iEntreeDao.delete(entityId);
    }

    @Override
    public void disableEntity(Entree entity) {

        if (entity.isDeleted()) {
            entity.setDeleted(false);
        } else {
            entity.setDeleted(true);
        }
    }

    @Override
    public Page<Entree> findPaginated(String numero, Date dateOperation, String observation, boolean deleted, int nombrePage, Integer size) {
        return iEntreeDao.findPaginated('%' + numero + '%', dateOperation, '%' + observation + '%', deleted, new PageRequest(nombrePage, size));
    }

    @Override
    public Entree findBynumero(String numero) {
        return iEntreeDao.findBynumero(numero);
    }

    @Override
    public List<Entree> findByDepartement(Departement departement) {
        return iEntreeDao.findByDepartement(departement);
    }

    @Override
    public List<Entree> findByUser(User user) {
        return iEntreeDao.findByUser(user);
    }

}
