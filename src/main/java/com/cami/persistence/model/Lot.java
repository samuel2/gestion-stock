/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author samuel
 */
@Entity
public class Lot extends EntityObject {

    @NotBlank
    private String numero;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateEntree;

    @NotNull
    private int quantite;

    @NotBlank
    private float prixUnitaire;

    @NotBlank
    private float prixVenteUnitaire;

    @NotBlank
    private float totalMontant;

    @NotBlank
    private String etat;

    @ManyToOne
    private Entree entrees;

    @ManyToOne
    private Fourniture fourniture;

    @OneToMany(mappedBy = "lot")
    private List<LigneOperation> ligneOperations;

    public Lot() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Fourniture getFourniture() {
        return fourniture;
    }

    public void setFourniture(Fourniture fourniture) {
        this.fourniture = fourniture;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public float getPrixVenteUnitaire() {
        return prixVenteUnitaire;
    }

    public void setPrixVenteUnitaire(float prixVenteUnitaire) {
        this.prixVenteUnitaire = prixVenteUnitaire;
    }

    public float getTotalMontant() {
        return totalMontant;
    }

    public void setTotalMontant(float totalMontant) {
        this.totalMontant = totalMontant;
    }

    public List<LigneOperation> getLigneOperations() {
        return ligneOperations;
    }

    public void setLigneOperations(List<LigneOperation> ligneOperations) {
        this.ligneOperations = ligneOperations;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Entree getEntrees() {
        return entrees;
    }

    public void setEntrees(Entree entrees) {
        this.entrees = entrees;
    }

}
