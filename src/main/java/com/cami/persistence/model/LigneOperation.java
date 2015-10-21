/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import java.io.Serializable;
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
public class LigneOperation extends EntityObject implements Serializable {

    @NotBlank
    private String numero;

    @NotNull
    private int quantitePhysique;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateRegulation;

    @NotNull
    private int quantiteEcart;

    @NotBlank
    private String observation;

    @NotNull
    private int ecartValeur;

    @ManyToOne(targetEntity = Lot.class)
    private Lot lot;

    @OneToMany(mappedBy = "ligneOperation")
    private List<Fourniture> fournitures;

    @OneToMany(mappedBy = "ligneOperation")
    private List<Entree> entrees;

    @OneToMany(mappedBy = "ligneOperation")
    private List<Sortie> sorties;

    @OneToMany(mappedBy = "ligneOperation")
    private List<Audi> audis;

    public LigneOperation() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getQuantitePhysique() {
        return quantitePhysique;
    }

    public void setQuantitePhysique(int quantitePhysique) {
        this.quantitePhysique = quantitePhysique;
    }

    public Date getDateRegulation() {
        return dateRegulation;
    }

    public void setDateRegulation(Date dateRegulation) {
        this.dateRegulation = dateRegulation;
    }

    public int getQuantiteEcart() {
        return quantiteEcart;
    }

    public void setQuantiteEcart(int quantiteEcart) {
        this.quantiteEcart = quantiteEcart;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public int getEcartValeur() {
        return ecartValeur;
    }

    public void setEcartValeur(int ecartValeur) {
        this.ecartValeur = ecartValeur;
    }

    public List<Fourniture> getFournitures() {
        return fournitures;
    }

    public void setFournitures(List<Fourniture> fournitures) {
        this.fournitures = fournitures;
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

    public List<Audi> getAudis() {
        return audis;
    }

    public void setAudis(List<Audi> audis) {
        this.audis = audis;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

}
