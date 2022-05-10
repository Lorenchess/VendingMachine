package com.lorenchess.hero.controller;

import com.lorenchess.hero.dao.LocationDao;
import com.lorenchess.hero.dao.OrganizationDao;
import com.lorenchess.hero.dao.SightingDao;
import com.lorenchess.hero.dao.SuperPersonDao;
import com.lorenchess.hero.entity.Organization;
import com.lorenchess.hero.entity.SuperPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SuperPersonController {
   @Autowired
   LocationDao locationDao;

   @Autowired
   OrganizationDao organizationDao;

   @Autowired
   SightingDao sightingDao;

   @Autowired
   SuperPersonDao superPersonDao;


   @GetMapping("superPerson")
   public String displaySuperPerson(Model model) {
       List<SuperPerson> superPeople = superPersonDao.getAllSuperPersons();
       model.addAttribute("superPeople", superPeople);
       return "superPerson";
   }

    @PostMapping("addSuperPerson")
    public String addSuperPeople(String superPersonName, String isHero, String superPersonDesc, String superPower) {
        SuperPerson superPeople = new SuperPerson();
        superPeople.setSuperPersonName(superPersonName);

        if (isHero.equals("true")) {
            superPeople.setHero(true);
        } else{
            superPeople.setHero(false);
        }

        superPeople.setSuperPersonDesc(superPersonDesc);
        superPeople.setSuperPower(superPower);

        superPersonDao.addSuperPerson(superPeople);

        return "redirect:/superPerson";
    }

    @GetMapping("deleteSuperPerson")
    public String deleteSuperPerson(Integer id) {
        superPersonDao.deleteSuperPersonById(id);
        return "redirect:/superPerson";
    }

    @GetMapping("editSuperPerson")
    public String editSuperPerson(Integer id, Model model) {
        SuperPerson superPerson = superPersonDao.getSuperPersonById(id);
        List<Organization> organizations = organizationDao.getAllOrganizations();

        model.addAttribute("superPerson", superPerson);
        model.addAttribute("organizations", organizations);

        return "editSuperPerson";
    }

    @PostMapping("editSuperPerson")
    public String performEditStudent(@Valid SuperPerson superPerson, BindingResult result) {
        if(result.hasErrors()) {
            return "editSuperPerson";
        }
        superPersonDao.updateSuperPerson(superPerson);
        return "redirect:/superPerson";
    }



}
