/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author samuel
 */
@Entity
public class Fourniture extends EntityObject implements Serializable {

    @NotBlank
    private String reference;

    @NotBlank
    private String designation;

    @NotNull
    private int quantite;

    @NotNull
    private int seuil;

    @NotBlank
    private String devise;

    @OneToMany(mappedBy = "fourniture")
    private List<Lot> lots;

    @ManyToOne(targetEntity = LigneOperation.class)
    private LigneOperation ligneOperation;

    @ManyToOne(targetEntity = Categorie.class)
    private Categorie categorie;

    public Fourniture() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getSeuil() {
        return seuil;
    }

    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }

    public LigneOperation getLigneOperation() {
        return ligneOperation;
    }

    public void setLigneOperation(LigneOperation ligneOperation) {
        this.ligneOperation = ligneOperation;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

}