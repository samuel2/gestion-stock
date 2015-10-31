/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IOperations<T extends Serializable> {

    //Recherche un objet via son id
    T findOne(final long id);

    //Retourne la liste d'objets
    List<T> findAll();

    Page<T> findPaginated(int page, int size);

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    public void disableEntity(final T entity);

    void deleteById(final long entityId);
}
