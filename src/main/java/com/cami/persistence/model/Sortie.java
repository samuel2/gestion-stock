/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author samuel
 */
@Entity
@DiscriminatorValue("Sortie")
public class Sortie extends Operation implements Serializable {

    @ManyToOne
    private Service service;

    @ManyToOne
    private LigneOperation ligneOperation;

    @OneToMany(mappedBy = "sortie")
    private List<Lot> lots;

    public Sortie() {
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LigneOperation getLigneOperation() {
        return ligneOperation;
    }

    public void setLigneOperation(LigneOperation ligneOperation) {
        this.ligneOperation = ligneOperation;
    }

    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }
}
