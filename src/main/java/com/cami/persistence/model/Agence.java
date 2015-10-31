/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
public class Agence extends EntityObject {

    @NotBlank
    private String code;

    @NotBlank
    private String intitule;

    @NotBlank
    private String region;

    @OneToMany(mappedBy = "agence")
    private List<Departement> departement;

    public Agence() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Departement> getDepartements() {
        return departement;
    }

    public void setDepartements(List<Departement> departements) {
        this.departement = departements;
    }

}
