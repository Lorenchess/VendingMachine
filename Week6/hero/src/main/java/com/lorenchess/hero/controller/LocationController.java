package com.lorenchess.hero.controller;

import com.lorenchess.hero.dao.LocationDao;
import com.lorenchess.hero.dao.OrganizationDao;
import com.lorenchess.hero.dao.SightingDao;
import com.lorenchess.hero.dao.SuperPersonDao;
import com.lorenchess.hero.entity.Location;
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
import java.util.List;

@Controller
public class LocationController {
    @Autowired
    LocationDao locationDao;

    @Autowired
    OrganizationDao organizationDao;

   @Autowired
   SightingDao sightingDao;

    @Autowired
    SuperPersonDao superPersonDao;

    @GetMapping("locations")
    public String displaySuperPerson(Model model) {
        List<Location> locations = locationDao.getAllLocations();

        model.addAttribute("locations", locations);

        return "locations";
    }

//    @PostMapping("addLocation")
//    public String addLocation(String locationName, String locationDesc, String locationAddress, String locationLatitude, String locationLongitude) {
//        Location location = new Location();
//        location.setLocationName(locationName);
//        location.setLocationDesc(locationDesc);
//        location.setLocationAddress(locationAddress);
//        location.setLocationLatitude(locationLatitude);
//        location.setLocationLongitude(locationLongitude);
//        locationDao.addLocation(location);
//        return "redirect:/locations";
//    }

    @PostMapping("addLocation")
    public String addLocation(HttpServletRequest request) {
        String locationName = request.getParameter("locationName");
        String locationDesc = request.getParameter("locationDesc");
        String locationAddress = request.getParameter("locationAddress");
        String locationLatitude = request.getParameter("locationLatitude");
        String locationLongitude = request.getParameter("locationLongitude");
        Location location = new Location();
        location.setLocationName(locationName);
        location.setLocationDesc(locationDesc);
        location.setLocationAddress(locationAddress);
        location.setLocationLatitude(locationLatitude);
        location.setLocationLongitude(locationLongitude);
        locationDao.addLocation(location);
        return "redirect:/locations";
    }


    @GetMapping("deleteLocation")
    public String deleteLocation(Integer id) {
        locationDao.deleteLocationById(id);
        return "redirect:/locations";
    }

    @GetMapping("editLocation")
    public String editLocation(Integer id, Model model) {
        Location location = locationDao.getLocationById(id);

        model.addAttribute("location", location);

        return "editLocation";
    }

    @PostMapping("editLocation")
    public String performEditStudent(@Valid Location location, BindingResult result) {
        if(result.hasErrors()) {
            return "editSuperPerson";
        }
        locationDao.updateLocation(location);
        return "redirect:/locations";
    }

















}
