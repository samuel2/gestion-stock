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
@DiscriminatorValue("Audit")
public class Audit extends Operation implements Serializable {

    @ManyToOne(targetEntity = Service.class)
    private Service service;

    @OneToMany(mappedBy = "audit")
    private List<LigneOperation> ligneOperations;

    @ManyToOne(targetEntity = User.class)
    private User user;

    public Audit() {
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<LigneOperation> getLigneOperations() {
        return ligneOperations;
    }

    public void setLigneOperations(List<LigneOperation> ligneOperations) {
        this.ligneOperations = ligneOperations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
