package com.lorenchess.hero.controller;

import com.lorenchess.hero.dao.LocationDao;
import com.lorenchess.hero.dao.OrganizationDao;
import com.lorenchess.hero.dao.SightingDao;
import com.lorenchess.hero.dao.SuperPersonDao;
import com.lorenchess.hero.entity.Location;
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
public class SightingController {

    @Autowired
    LocationDao locationDao;

    @Autowired
    OrganizationDao organizationDao;

   @Autowired
   SightingDao sightingDao;

    @Autowired
    SuperPersonDao superPersonDao;


    @GetMapping("sightings")
    public String displaySightings(Model model) {
        List<Sighting> sightings = sightingDao.getAllSightings();

        model.addAttribute("sightings", sightings);

        return "sightings";
    }

    @PostMapping("addSighting")
    public String addSighting(String superPersonName, String isHero, LocalDate sightDate, String location) {
        Sighting sighting = new Sighting();

        sighting.setSuperPersonName(superPersonName);
        sighting.setIsHero(isHero);
        sighting.setSightDate(sightDate);
        sighting.setLocation(location);

        sightingDao.addSighting(sighting);
        return "redirect:/sightings";
    }


    @GetMapping("deleteSighting")
    public String deleteSighting(Integer id) {
        sightingDao.deleteSightingById(id);
        return "redirect:/sightings";
    }

    @GetMapping("editSighting")
    public String editSighting(Integer id, Model model) {
        Sighting sighting = sightingDao.getSightingById(id);
        model.addAttribute("student", sighting);
        return "editSighting";
    }

    @PostMapping("editSighting")
    public String performEditStudent(@Valid Sighting sighting, BindingResult result) {
        if(result.hasErrors()) {
            return "editSighting";
        }
        sightingDao.updateSighting(sighting);
        return "redirect:/sightings";
    }

}
