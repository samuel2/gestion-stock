/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.dao;

import com.cami.persistence.model.Entree;
import com.cami.persistence.model.Fourniture;
import com.cami.persistence.model.Lot;
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
public interface ILotDao extends JpaRepository<Lot, Long>, JpaSpecificationExecutor<Lot> {

    @Query("SELECT l FROM Lot l WHERE l.entree = :entree")
    public List<Lot> findByEntree(@Param("entree") Entree entree);

    @Query("SELECT l FROM Lot l WHERE l.fourniture = :fourniture")
    public List<Lot> findByFourniture(@Param("fourniture") Fourniture fourniture);

    @Query("SELECT l FROM Lot l WHERE l.numero LIKE :numero AND "
            + "l.dateEntree <= :dateEntree AND "
            + "l.prixUnitaire = :prixUnitaire AND "
            + "l.prixVenteUnitaire = :prixVenteUnitaire AND "
            + "l.quantite = :quantite AND "
            + "l.totalMontant = :totalMontant AND "
            + "l.etat LIKE :etat AND "
            + "l.deleted = :deleted")
    Page<Lot> searchLots(
            @Param("numero") String numero,
            @Param("dateEntree") Date dateEntree,
            @Param("prixUnitaire") float prixUnitaire,
            @Param("prixVenteUnitaire") float prixVenteUnitaire,
            @Param("quantite") int quantite,
            @Param("totalMontant") int totalMontant,
            @Param("etat") String etat,
            @Param("deleted") boolean deleted,
            Pageable pageable
    );
}
