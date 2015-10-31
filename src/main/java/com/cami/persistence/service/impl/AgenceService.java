/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.service.impl;

import com.cami.persistence.dao.IAgenceDao;
import com.cami.persistence.model.Agence;
import com.cami.persistence.service.IAgenceService;
import com.cami.persistence.service.common.AbstractService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Transactional
public class AgenceService extends AbstractService<Agence> implements IAgenceService {

    @Autowired
    private IAgenceDao iAgenceDao;

    public AgenceService() {
        super();
    }

    @Override
    protected PagingAndSortingRepository<Agence, Long> getDao() {
        return iAgenceDao;
    }

    @Override
    public void disableEntity(Agence entity) {

        if (entity.isDeleted()) {
            entity.setDeleted(false);
        } else {
            entity.setDeleted(true);
        }
    }

    @Override
    public List<Agence> searchAgences(String code, String intitule, String region) {
        List<Agence> agences;
        agences = iAgenceDao.searchAgences(code, intitule, region);
        return agences;
    }

}
