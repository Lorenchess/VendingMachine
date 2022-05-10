package com.lorenchess.hero.controller;

import com.lorenchess.hero.dao.LocationDao;
import com.lorenchess.hero.dao.OrganizationDao;
import com.lorenchess.hero.dao.SightingDao;
import com.lorenchess.hero.dao.SuperPersonDao;
import com.lorenchess.hero.entity.Location;
import com.lorenchess.hero.entity.Organization;
import com.lorenchess.hero.entity.Sighting;
import com.lorenchess.hero.entity.SuperPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class OrganizationController {
    @Autowired
    LocationDao locationDao;

    @Autowired
    OrganizationDao organizationDao;

    @Autowired
    SightingDao sightingDao;

    @Autowired
    SuperPersonDao superPersonDao;


    @GetMapping("organizations")
    public String displayOrganizations(Model model) {
        List<Organization> organizations = organizationDao.getAllOrganizations();
        model.addAttribute("organizations", organizations);

        return "organizations";
    }

    @PostMapping("addOrganization")
    public String addOrganization(String orgName, String orgDescription, String orgContactInfo) {
        Organization organization = new Organization();
        organization.setOrgName(orgName);
        organization.setOrgDescription(orgDescription);
        organization.setOrgContactInfo(orgContactInfo);
        organizationDao.addOrganization(organization);
        return "redirect:/organizations";
    }

    @GetMapping("deleteOrganization")
    public String deleteOrganization(Integer id) {
        organizationDao.deleteOrganizationById(id);
        return "redirect:/organizations";
    }


    @GetMapping("editOrganization")
    public String editOrganization(Integer id, Model model) {
        Organization organization = organizationDao.getOrganizationById(id);
        model.addAttribute("organization", organization);
        return "editOrganization";
    }


    @PostMapping("editOrganization")
    public String performEditOrganization(@Valid Organization organization, BindingResult result) {
        if(result.hasErrors()) {
            return "editOrganization";
        }
        organizationDao.updateOrganization(organization);
        return "redirect:/organizations";
    }









}
