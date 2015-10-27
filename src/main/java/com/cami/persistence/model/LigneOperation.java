/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
public class LigneOperation extends EntityObject {

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

    @ManyToOne
    private Sortie sortie;

    @ManyToOne
    private Audit audi;

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

    public Sortie getSortie() {
        return sortie;
    }

    public void setSortie(Sortie sortie) {
        this.sortie = sortie;
    }

    public Audit getAudi() {
        return audi;
    }

    public void setAudi(Audit audi) {
        this.audi = audi;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

}
