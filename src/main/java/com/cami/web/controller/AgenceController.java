/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cami.web.controller;

import com.cami.persistence.model.Agence;
import com.cami.persistence.service.IAgenceService;
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
@RequestMapping("/agence")
public class AgenceController {

    @Autowired
    private IAgenceService iAgenceService;

    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String showAction(@PathVariable("id") final Long id, final ModelMap model) {

        final Agence agence = iAgenceService.findOne(id);
        model.addAttribute("agence", agence);
        return "/agence/show";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String indexAction(final ModelMap model, final WebRequest webRequest) {

        final String code = webRequest.getParameter("code") != null ? webRequest.getParameter("code") : "";
        final String intitule = webRequest.getParameter("intitule") != null ? webRequest.getParameter("intitule") : "";
        final String region = webRequest.getParameter("region") != null ? webRequest.getParameter("region") : "";

        final Integer page = webRequest.getParameter("page") != null ? Integer.valueOf(webRequest.getParameter("page")) : 0;
        final Integer size = webRequest.getParameter("size") != null ? Integer.valueOf(webRequest.getParameter("size")) : 55;

        boolean deleted = false;
        if (webRequest.getParameter("querydeleted") != null) {
            deleted = webRequest.getParameter("querydeleted").equals("true");
        }

        final Page<Agence> resultPage = iAgenceService.findPaginated(page, size);

        final Agence agence = new Agence();
        agence.setCode(code);
        agence.setIntitule(intitule);
        agence.setRegion(region);
        model.addAttribute("agence", agence);
        model.addAttribute("page", page);
        model.addAttribute("Totalpage", resultPage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("agences", resultPage.getContent());

        return "agence/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAction(final ModelMap model) {
        final Agence agence = new Agence();
        model.addAttribute("agence", agence);
        return "agence/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAction(@Valid final Agence agence, final BindingResult result,
            final ModelMap model, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            model.addAttribute("agence", agence);
            return "agence/new";
        } else {
            iAgenceService.create(agence);
            return "redirect:/agence/" + agence.getId() + "/show";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteAction(final Agence agence) {
        final Agence agenceToDisable = iAgenceService.findOne(agence.getId());
        iAgenceService.disableEntity(agenceToDisable);
        return "redirect:/agence/";
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
    public String editAction(@PathVariable("id") final Long id, final ModelMap model) {
        final Agence agence = iAgenceService.findOne(id);
        model.addAttribute("agence", agence);
        return "/agence/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAction(@Valid final Agence agence, final ModelMap model,
            final BindingResult result, final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            return "agence/edit";
        } else {
            iAgenceService.update(agence);
            return "redirect:/agence/" + agence.getId() + "/show";
        }
    }
}
