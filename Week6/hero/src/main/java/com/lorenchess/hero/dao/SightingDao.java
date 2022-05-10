package com.lorenchess.hero.dao;

import com.lorenchess.hero.entity.Location;
import com.lorenchess.hero.entity.Sighting;
import com.lorenchess.hero.entity.SuperPerson;

import java.util.List;

public interface SightingDao {
    Sighting getSightingById(int id);
    List<Sighting> getAllSightings();
    Sighting addSighting(Sighting sighting);
    void updateSighting(Sighting sighting);
    void deleteSightingById(int id);

    List<Sighting> getSightingForLocation(Location location);
    List<Sighting> getSightingForSuperPerson(SuperPerson superPerson);
}
