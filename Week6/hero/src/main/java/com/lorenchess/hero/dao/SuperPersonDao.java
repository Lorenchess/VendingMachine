package com.lorenchess.hero.dao;

import com.lorenchess.hero.entity.SuperPerson;

import java.util.List;

public interface SuperPersonDao {
    SuperPerson getSuperPersonById(int id);
    List<SuperPerson> getAllSuperPersons();
    SuperPerson addSuperPerson(SuperPerson superPerson);
    void updateSuperPerson(SuperPerson superPerson);
    void deleteSuperPersonById(int id);
}
