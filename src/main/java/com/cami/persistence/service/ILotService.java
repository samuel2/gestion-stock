/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.service;

import com.cami.persistence.IOperations;
import com.cami.persistence.model.Entree;
import com.cami.persistence.model.Fourniture;
import com.cami.persistence.model.Lot;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface ILotService extends IOperations<Lot> {

    public List<Lot> findByEntree(Entree entree);

    public List<Lot> findByFourniture(Fourniture fourniture);

    Page<Lot> searchLots(String numero, Date dateEntree, float prixUnitaire, float prixVenteUnitaire, int quantite, int totalMontant, String etat, boolean deleted, int page, Integer size);
}
