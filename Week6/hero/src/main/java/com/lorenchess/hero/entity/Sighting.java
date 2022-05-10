package com.lorenchess.hero.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Sighting {
    private int id;
    private String superPersonName;
    String isHero;
    private LocalDate sightDate;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuperPersonName() {
        return superPersonName;
    }

    public void setSuperPersonName(String superPersonName) {
        this.superPersonName = superPersonName;
    }

    public LocalDate getSightDate() {
        return sightDate;
    }

    public void setSightDate(LocalDate sightDate) {
        this.sightDate = sightDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsHero() {
        return isHero;
    }

    public void setIsHero(String isHero) {
        this.isHero = isHero;
    }
}
