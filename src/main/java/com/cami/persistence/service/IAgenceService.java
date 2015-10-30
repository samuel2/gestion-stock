/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.service;

import com.cami.persistence.IOperations;
import com.cami.persistence.model.Agence;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IAgenceService extends IOperations<Agence> {

    List<Agence> searchAgences(String code, String intitule, String region);

    Page<Agence> findPagineted(String code, String intitule, String region, boolean deleted, Pageable pageable);
}
