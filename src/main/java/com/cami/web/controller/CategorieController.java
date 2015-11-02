/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.web.controller;

import com.cami.persistence.model.Categorie;
import com.cami.persistence.service.ICategorieService;
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
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private ICategorieService iCategorieService;

    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String showAction(@PathVariable("id") final Long id, final ModelMap model) {
        final Categorie categorie = iCategorieService.findOne(id);
        model.addAttribute("categorie", categorie);
        return "/categorie/show";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editAction(@PathVariable("id") Long id, final ModelMap model) {
        final Categorie categorie = iCategorieService.findOne(id);
        model.addAttribute("categorie", categorie);
        return "/categorie/edit";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteAction(@PathVariable("id") final Long id, final ModelMap model) {
        Categorie cat = iCategorieService.findOne(id);
        iCategorieService.disableEntity(cat);
        return "redirect:/categorie/";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String indexAction(final ModelMap model, final WebRequest webRequest) {

        final String intitule = webRequest.getParameter("intitule") != null ? webRequest.getParameter("intitule") : "";

        final Integer page = webRequest.getParameter("page") != null ? Integer.valueOf(webRequest.getParameter("page")) : 0;
        final Integer size = webRequest.getParameter("size") != null ? Integer.valueOf(webRequest.getParameter("size")) : 55;

        boolean deleted = false;
        if (webRequest.getParameter("deleted") != null) {
            deleted = webRequest.getParameter("deleted").equals("true");
        }

        final Page<Categorie> resultPage = iCategorieService.findPaginated(intitule, deleted, page, size);

        final Categorie categorie = new Categorie();
        categorie.setIntitule(intitule);
        model.addAttribute("categorie", categorie);
        model.addAttribute("page", page);
        model.addAttribute("Totalpage", resultPage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("categories", resultPage.getContent());
        return "categorie/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAction(@Valid final Categorie categorie, final ModelMap model,
            final BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            model.addAttribute("categorie", categorie);
            return "categorie/new";
        } else {
            iCategorieService.create(categorie);
            return "redirect:/categorie/" + categorie.getId() + "/show";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAction(@Valid final Categorie categorie, final ModelMap model,
            final BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            return "categorie/edit";
        } else {
            iCategorieService.update(categorie);
            return "redirect:/categorie/" + categorie.getId() + "/show";
        }
    }
}
