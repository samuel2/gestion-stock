/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.web.controller;

import com.cami.persistence.model.Fourniture;
import com.cami.persistence.service.ICategorieService;
import com.cami.persistence.service.IFournitureService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Controller
@RequestMapping("/fourniture")
public class FournitureController {

    @Autowired
    private IFournitureService iFournitureService;

    @Autowired
    private ICategorieService iCategorieService;

    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String showAction(@PathVariable("id") final Long id, final ModelMap model) {
        final Fourniture fourniture = iFournitureService.findOne(id);
        model.addAttribute("fourniture", fourniture);
        return "/fourniture/show";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editAction(@PathVariable("id") final Long id, final ModelMap model) {
        final Fourniture fourniture = iFournitureService.findOne(id);
        model.addAttribute("fourniture", fourniture);
        return "/fourniture/edit";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteAction(@PathVariable("id") final Long id, final RedirectAttributes redirectAttributes) {
        final Fourniture fournitureToDisable = iFournitureService.findOne(id);
        iFournitureService.disableEntity(fournitureToDisable);
        return "redirect:/fourniture/";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String indexAction(final ModelMap model, final WebRequest webRequest) {

        final String designation = webRequest.getParameter("designation") != null ? webRequest.getParameter("designation") : "";
        final String reference = webRequest.getParameter("reference") != null ? webRequest.getParameter("reference") : "";
        final Integer quantite = webRequest.getParameter("quantite") != null ? Integer.valueOf(webRequest.getParameter("quantite")) : 0;
        final Integer seuil = webRequest.getParameter("seuil") != null ? Integer.valueOf(webRequest.getParameter("seuil")) : 0;
        final Integer page = webRequest.getParameter("page") != null ? Integer.valueOf(webRequest.getParameter("page")) : 0;
        final Integer size = webRequest.getParameter("size") != null ? Integer.valueOf(webRequest.getParameter("size")) : 55;

        boolean deleted = false;
        if (webRequest.getParameter("deleted") != null) {
            deleted = webRequest.getParameter("deleted").equals("true");
        }

        final Page<Fourniture> resultPage = iFournitureService.findPaginated(reference, designation, quantite, seuil, deleted, page, size);

        final Fourniture fourniture = new Fourniture();
        fourniture.setReference(reference);
        fourniture.setDesignation(designation);
        fourniture.setQuantite(quantite);
        fourniture.setSeuil(seuil);
        fourniture.setCategorie(iCategorieService.findOne(fourniture.getCategorie().getId()));
        model.addAttribute("fourniture", fourniture);
        model.addAttribute("page", page);
        model.addAttribute("Totalpage", resultPage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("fournitures", resultPage.getContent());
        return "fourniture/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAction(@Valid final Fourniture fourniture, final ModelMap model,
            final BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            model.addAttribute("fourniture", fourniture);
            return "fourniture/new";
        } else {
            iFournitureService.create(fourniture);
            return "redirect:/fourniture/" + fourniture.getId() + "/show";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAction(@Valid final Fourniture fourniture, final ModelMap model,
            final BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            return "fourniture/edit";
        } else {
            iFournitureService.update(fourniture);
            return "redirect:/fourniture/" + fourniture.getId() + "/show";
        }
    }
}
