/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.service.impl;

import com.cami.persistence.dao.IDepartementDao;
import com.cami.persistence.model.Departement;
import com.cami.persistence.service.IDepartementService;
import com.cami.persistence.service.common.AbstractService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Service("departementService")
public class DepartementService extends AbstractService<Departement> implements IDepartementService {

    @Autowired
    private IDepartementDao iDepartementDao;

    public DepartementService() {
        super();
    }

    @Override
    protected PagingAndSortingRepository<Departement, Long> getDao() {
        return iDepartementDao;
    }

    @Override
    public void disableEntity(Departement entity) {

        if (entity.isDeleted()) {
            entity.setDeleted(false);
        } else {
            entity.setDeleted(true);
        }
    }

    @Override
    public List<Departement> searchDepartements(String code, String intitule) {
        List<Departement> services;
        services = iDepartementDao.searchDepartements(code, intitule);
        return services;
    }

    @Override
    public List<Departement> filterDepartementByAgenceId(long agenceId) {
        List<Departement> services;
        services = iDepartementDao.filterDepartementByAgenceId(agenceId);
        return services;
    }

}
