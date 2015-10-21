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
@DiscriminatorValue("Entree")
public class Entree extends Operation implements Serializable {

    @ManyToOne(targetEntity = Service.class)
    private Service service;

    @ManyToOne(targetEntity = LigneOperation.class)
    private LigneOperation ligneOperation;

    @OneToMany(mappedBy = "entree")
    private List<Lot> lots;

    public Entree() {
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
