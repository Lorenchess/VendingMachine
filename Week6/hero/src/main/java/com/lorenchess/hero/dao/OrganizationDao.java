package com.lorenchess.hero.dao;

import com.lorenchess.hero.entity.Location;
import com.lorenchess.hero.entity.Organization;
import com.lorenchess.hero.entity.SuperPerson;

import java.util.List;

public interface OrganizationDao {
    Organization getOrganizationById(int id);
    List<Organization> getAllOrganizations();
    Organization addOrganization(Organization organization);
    void updateOrganization(Organization organization);
    void deleteOrganizationById(int id);

    List<Organization> getOrganizationForSuperPerson(SuperPerson superPerson);
}
