/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.service.impl;

import com.cami.persistence.dao.IServiceDao;
import com.cami.persistence.model.Service;
import com.cami.persistence.service.IServiceService;
import com.cami.persistence.service.common.AbstractService;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Transactional
public class ServiceService extends AbstractService<Service> implements IServiceService {

    private IServiceDao iServiceDao;

    public ServiceService() {
        super();
    }

    @Override
    protected PagingAndSortingRepository<Service, Long> getDao() {
        return iServiceDao;
    }

    @Override
    public void disableEntity(Service entity) {

        if (entity.isDeleted()) {
            entity.setDeleted(false);
        } else {
            entity.setDeleted(true);
        }
    }

    @Override
    public List<Service> searchServices(String code, String intitule) {
        List<Service> services;
        services = iServiceDao.searchServices(code, intitule);
        return services;
    }

    @Override
    public List<Service> filterByAgenceId(long agenceId) {
        List<Service> services;
        services = iServiceDao.filterByAgenceId(agenceId);
        return services;
    }

}
