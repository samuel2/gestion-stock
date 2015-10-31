/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.dao;

import com.cami.persistence.model.Agence;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IAgenceDao extends JpaRepository<Agence, Long>, JpaSpecificationExecutor<Agence> {

    @Query("SELECT * FROM Agence a WHERE a.code LIKE :code OR a.intitule LIKE :intitule OR a.region LIKE :region")
    List<Agence> searchAgences(@Param("code") String code, @Param("intitule") String intitule, @Param("region") String region);

}
