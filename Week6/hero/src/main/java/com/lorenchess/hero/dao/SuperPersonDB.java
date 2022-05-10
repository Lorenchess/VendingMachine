package com.lorenchess.hero.dao;

import com.lorenchess.hero.entity.Organization;
import com.lorenchess.hero.entity.SuperPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SuperPersonDB implements SuperPersonDao{
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public SuperPerson getSuperPersonById(int id) {
        try {
            final String SELECT_SUPER_PERSON_BY_ID = "SELECT * FROM SuperPerson WHERE id = ?";
            SuperPerson superPerson =  jdbc.queryForObject(SELECT_SUPER_PERSON_BY_ID, new SuperPersonMapper(), id);
            return superPerson;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    private List<Organization> getOrganizationPerSuperPerson(int id){
        final String SELECT_ORGANIZATION = "SELECT * FROM SuperPerson_Organization WHERE superPersonId = ?";
        return jdbc.query(SELECT_ORGANIZATION, new OrganizationDB.OrganizationMapper(), id);
    }

    @Override
    public List<SuperPerson> getAllSuperPersons() {
        final String SELECT_ALL_SUPER_PERSONS = "SELECT * FROM SuperPerson";
        return jdbc.query(SELECT_ALL_SUPER_PERSONS, new SuperPersonMapper());
    }

    @Override
    @Transactional
    public SuperPerson addSuperPerson(SuperPerson superPerson) {
        final String INSET_SUPER_PERSON = "INSERT INTO SuperPerson(superPersonName,isHero,superPersonDesc,superPower) VALUES(?,?,?,?)";
        jdbc.update(INSET_SUPER_PERSON,
                superPerson.getSuperPersonName(),
                superPerson.isHero(),
                superPerson.getSuperPersonDesc(),
                superPerson.getSuperPower());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        superPerson.setSuperPersonId(newId);
        return superPerson;
    }

    @Override
    public void updateSuperPerson(SuperPerson superPerson) {
      final String UPDATE_SUPER_PERSON = "UPDATE SuperPerson SET superPersonName = ?,isHero = ?,superPersonDesc = ?,superPower = ? WHERE superPersonId = ?";
      jdbc.update(UPDATE_SUPER_PERSON,
              superPerson.getSuperPersonName(),
              superPerson.isHero(),
              superPerson.getSuperPersonDesc(),
              superPerson.getSuperPower(),
              superPerson.getSuperPersonId());
    }


    @Override
    @Transactional
    public void deleteSuperPersonById(int id) {
      final String DELETE_SUPER_PERSON_ORGANIZATION = "DELETE FROM SuperPerson_Organization WHERE superPersonId = ?";
      jdbc.update(DELETE_SUPER_PERSON_ORGANIZATION, id);

      final String DELETE_SUPER_PERSON_SIGHTING = "DELETE FROM SuperPerson_Sighting WHERE superPersonId = ?";
      jdbc.update(DELETE_SUPER_PERSON_SIGHTING, id);

      final String DELETE_SUPER_PERSON = "DELETE FROM SuperPerson WHERE superPersonId = ?";
      jdbc.update(DELETE_SUPER_PERSON, id);
    }



    public static final class SuperPersonMapper implements RowMapper<SuperPerson>{

        @Override
        public SuperPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
            SuperPerson superPerson = new SuperPerson();
            superPerson.setSuperPersonId(rs.getInt("superPersonId"));
            superPerson.setSuperPersonName(rs.getString("superPersonName"));
            superPerson.setHero(rs.getBoolean("isHero"));
            superPerson.setSuperPersonDesc(rs.getString("superPersonDesc"));
            superPerson.setSuperPower(rs.getString("superPower"));
            return superPerson;
        }
    }
}
