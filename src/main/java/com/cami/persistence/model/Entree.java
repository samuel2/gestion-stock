/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author samuel
 */
@Entity
@DiscriminatorValue("Entree")
public class Entree extends Operation {

    @ManyToOne(targetEntity = Departement.class)
    private Departement departement;

    @ManyToOne(targetEntity = User.class)
    private User user;

    public Entree() {
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
