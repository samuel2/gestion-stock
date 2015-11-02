/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.dao;

import com.cami.persistence.model.Departement;
import com.cami.persistence.model.Entree;
import com.cami.persistence.model.User;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IEntreeDao extends JpaRepository<Entree, Long>, JpaSpecificationExecutor<Entree> {

    @Query("SELECT e FROM Entree e WHERE e.numero LIKE :numero")
    public Entree findBynumero(@Param("numero") String numero);

    @Query("SELECT e FROM Entree e WHERE e.departement = :departement")
    public List<Entree> findByDepartement(@Param("departement") Departement departement);

    @Query("SELECT e FROM Entree e WHERE e.user = :user")
    public List<Entree> findByUser(@Param("user") User user);

    @Query("SELECT e FROM Entree e WHERE "
            + "e.numero LIKE :numero AND "
            + "e.dateOperation <= :dateOperation AND "
            + "e.observation LIKE :observation AND "
            + "e.deleted = :deleted")
    Page<Entree> findPaginated(
            @Param("numero") String numero,
            @Param("dateOperation") Date dateOperation,
            @Param("observation") String observation,
            @Param("deleted") boolean deleted,
            Pageable pageable
    );
}
