/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
public class Role extends EntityObject
{

    @NotBlank(message = "{blank.message}")
    @Size(min = 4, max = 255, message = "{size.message}")
    private String intitule;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Role()
    {
    }

    public String getIntitule()
    {
        return intitule;
    }

    public void setIntitule(String intitule)
    {
        this.intitule = intitule;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

}
