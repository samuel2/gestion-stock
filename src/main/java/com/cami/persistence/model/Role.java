/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author samuel
 */
@Entity
public class Role extends EntityObject implements Serializable {

    @NotBlank
    private String intitule;

    public Role() {
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

}
