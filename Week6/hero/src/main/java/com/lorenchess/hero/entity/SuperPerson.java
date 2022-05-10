package com.lorenchess.hero.entity;

import java.util.List;
import java.util.Objects;

public class SuperPerson {
    private int superPersonId;
    private String superPersonName;
    private boolean isHero;
    private String superPersonDesc;
    private String superPower;

    public SuperPerson() {
    }

    public SuperPerson(boolean isHero) {
        this.isHero = isHero;
    }

    public int getSuperPersonId() {
        return superPersonId;
    }

    public void setSuperPersonId(int superPersonId) {
        this.superPersonId = superPersonId;
    }

    public String getSuperPersonName() {
        return superPersonName;
    }

    public void setSuperPersonName(String superPersonName) {
        this.superPersonName = superPersonName;
    }

    public boolean isHero() {
        return isHero;
    }

    public void setHero(boolean hero) {
        isHero = hero;
    }

    public String getSuperPersonDesc() {
        return superPersonDesc;
    }

    public void setSuperPersonDesc(String superPersonDesc) {
        this.superPersonDesc = superPersonDesc;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuperPerson)) return false;
        SuperPerson that = (SuperPerson) o;
        return getSuperPersonId() == that.getSuperPersonId() && isHero() == that.isHero() && getSuperPersonName().equals(that.getSuperPersonName()) && getSuperPersonDesc().equals(that.getSuperPersonDesc()) && getSuperPower().equals(that.getSuperPower());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSuperPersonId(), getSuperPersonName(), isHero(), getSuperPersonDesc(), getSuperPower());
    }
}
