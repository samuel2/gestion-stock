/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
public class Departement extends EntityObject {

    @NotBlank
    private String code;

    @NotBlank
    private String intitule;

    @ManyToOne
    private Agence agence;

    @OneToMany(mappedBy = "departement")
    private List<Entree> entrees;

    @OneToMany(mappedBy = "departement")
    private List<Sortie> sorties;

    @OneToMany(mappedBy = "departement")
    private List<Audit> audits;

    public Departement() {
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

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public List<Entree> getEntrees() {
        return entrees;
    }

    public void setEntrees(List<Entree> entrees) {
        this.entrees = entrees;
    }

    public List<Sortie> getSorties() {
        return sorties;
    }

    public void setSorties(List<Sortie> sorties) {
        this.sorties = sorties;
    }

    public List<Audit> getAudits() {
        return audits;
    }

    public void setAudits(List<Audit> audits) {
        this.audits = audits;
    }

}
