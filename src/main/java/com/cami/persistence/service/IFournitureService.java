/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.service;

import com.cami.persistence.IOperations;
import com.cami.persistence.model.Fourniture;
import java.util.List;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IFournitureService extends IOperations<Fourniture> {

    public List<Fourniture> searchFournitures(String reference, String designation, int quantite, int seuil);
}
