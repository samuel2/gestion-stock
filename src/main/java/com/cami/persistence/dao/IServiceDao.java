/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.dao;

import com.cami.persistence.model.Service;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IServiceDao extends JpaRepository<Service, Long>, JpaSpecificationExecutor<Service> {

    @Query("SELECT * FROM Service s WHERE s.code LIKE :code OR s.intitule LIKE :intitule")
    List<Service> searchServices(@Param("code") String code, @Param("intitule") String intitule);

    @Query("SELECT * FROM Service s WHERE s.agence.id = :agenceId")
    List<Service> filterByAgenceId(@Param("agenceId") long agenceId);
}
