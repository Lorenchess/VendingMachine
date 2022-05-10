package com.lorenchess.hero.dao;

import com.lorenchess.hero.entity.Location;
import com.lorenchess.hero.entity.Sighting;
import com.lorenchess.hero.entity.SuperPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class SightingDB implements SightingDao{
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Sighting getSightingById(int id) {
        try {
            final String SELECT_SIGHTING_BY_ID = "SELECT * FROM Sighting WHERE id = ?";
            Sighting sighting = jdbc.queryForObject(SELECT_SIGHTING_BY_ID, new SightingMapper(), id);

            return sighting;
        } catch(DataAccessException ex) {
            return null;
        }
    }

    private List<SuperPerson> getSuperPersonsForSighting(int id) {
        final String SELECT_SUPER_PERSON_FOR_SIGHTING = "SELECT s.* FROM SuperPerson s "
                + "JOIN SuperPerson_Sighting ss ON ss.superPersonId = s.superPersonId WHERE ss.sightingId = ?";
        return jdbc.query(SELECT_SUPER_PERSON_FOR_SIGHTING, new SuperPersonDB.SuperPersonMapper(), id);
    }

    private Location getLocationForSighting(int id) {
        final String SELECT_LOCATION_FOR_SIGHTING = "SELECT l.* FROM Location l "
                + "JOIN Sighting s ON s.locationId = l.locationId WHERE s.id = ?";
        return jdbc.queryForObject(SELECT_LOCATION_FOR_SIGHTING, new LocationDB.LocationMapper(), id);
    }

    @Override
    public List<Sighting> getAllSightings() {
        final String SELECT_ALL_SIGHTINGS = "SELECT * FROM Sighting";
        List<Sighting> sightings = jdbc.query(SELECT_ALL_SIGHTINGS, new SightingMapper());

        return sightings;
    }


    @Override
    @Transactional
    public Sighting addSighting(Sighting sighting) {
        final String INSERT_SIGHTING = "INSERT INTO Sighting(superPersonName,isHero,sightDate, location) "
                + "VALUES(?,?,?,?)";
        jdbc.update(INSERT_SIGHTING,
                sighting.getSuperPersonName(),
                sighting.getIsHero(),
                sighting.getSightDate(),
                sighting.getLocation());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        sighting.setId(newId);
        return sighting;
    }

    @Override
    @Transactional
    public void updateSighting(Sighting sighting) {
        final String UPDATE_SIGHTING = "UPDATE Sighting SET sightDate = ?, locationId = ? WHERE id = ?";
        jdbc.update(UPDATE_SIGHTING,
                sighting.getSightDate(),
                sighting.getLocation(),
                sighting.getId());

        final String DELETE_SUPER_PERSON_SIGHTING = "DELETE FROM SuperPerson_Sighting WHERE sightingId = ?";
        jdbc.update(DELETE_SUPER_PERSON_SIGHTING, sighting.getId());
    }

    @Override
    @Transactional
    public void deleteSightingById(int id) {
        final String DELETE_SUPER_PERSON_SIGHTING = "DELETE FROM SuperPerson_Sighting WHERE sightingId = ?";
        jdbc.update(DELETE_SUPER_PERSON_SIGHTING, id);

        final String DELETE_SIGHTING = "DELETE FROM Sighting WHERE id = ?";
        jdbc.update(DELETE_SIGHTING, id);
    }

    @Override
    public List<Sighting> getSightingForLocation(Location location) {
        final String SELECT_SIGHTING_FOR_LOCATION = "SELECT * FROM Sighting WHERE locationId = ?";
        List<Sighting> sightings = jdbc.query(SELECT_SIGHTING_FOR_LOCATION,
                                   new SightingMapper(), location.getLocationId());

        return sightings;
    }

    @Override
    public List<Sighting> getSightingForSuperPerson(SuperPerson superPerson) {
        final String SELECT_SIGHTING_FOR_SUPER_PERSON = "SELECT s.* FROM Sighting s JOIN "
                + "SuperPerson_Sighting ss ON ss.sightingId = s.id WHERE ss.superPersonId = ?";
        List<Sighting> courses = jdbc.query(SELECT_SIGHTING_FOR_SUPER_PERSON,
                new SightingMapper(), superPerson.getSuperPersonId());

        return courses;
    }

    public static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sighting sighting = new Sighting();
            sighting.setId(rs.getInt("id"));
            sighting.setSuperPersonName(rs.getString("superPersonName"));
            sighting.setIsHero(rs.getString("isHero"));
            sighting.setSightDate(LocalDate.parse(rs.getString("sightDate")));
            sighting.setLocation(rs.getString("location"));
            return sighting;
        }
    }
}
