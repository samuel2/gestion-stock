/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.persistence.service;

import com.cami.persistence.IOperations;
import com.cami.persistence.model.Departement;
import java.util.List;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IDepartementService extends IOperations<Departement> {

    List<Departement> searchDepartements(String code, String intitule);

    List<Departement> filterDepartementByAgenceId(long agenceId);

}
