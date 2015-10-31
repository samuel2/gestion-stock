/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
public class User extends EntityObject {

    @NotBlank(message = "{blank.message")
    @Size(min = 3, max = 100, message = "{size.message}")
    private String nom;

    @NotBlank(message = "{blank.message")
    @Size(min = 3, max = 100, message = "{size.message}")
    private String prenom;

    @NotBlank(message = "{blank.message")
    @Email
    private String email;

    @NotBlank(message = "{blank.message")
    @Size(min = 3, max = 25, message = "{size.message}")
    private String username;

    @NotBlank(message = "{blank.message")
    @Size(min = 5, max = 255, message = "{size.message}")
    private String password;

    @Transient
    @NotBlank(message = "{blank.message")
    @Size(min = 5, max = 255, message = "{size.message}")
    private String passwordConfirm;

    @OneToMany(mappedBy = "user")
    private List<Audit> audis;

    @OneToMany(mappedBy = "user")
    private List<Entree> entrees;

    @OneToMany(mappedBy = "user")
    private List<Sortie> sorties;

    @ManyToMany
    private List<Categorie> categories;

    public User() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Audit> getAudis() {
        return audis;
    }

    public void setAudis(List<Audit> audis) {
        this.audis = audis;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
