package com.lorenchess.hero.dao;

import com.lorenchess.hero.entity.Location;
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
public class LocationDB implements LocationDao{
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Location getLocationById(int id) {
        try {
            final String GET_LOCATION_BY_ID = "SELECT * FROM Location WHERE locationId = ?";
            return jdbc.queryForObject(GET_LOCATION_BY_ID, new LocationMapper(), id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations() {
        final String GET_ALL_LOCATIONS = "SELECT * FROM Location";
        return jdbc.query(GET_ALL_LOCATIONS, new LocationMapper());
    }

    @Override
    @Transactional
    public Location addLocation(Location location) {
        final String INSET_LOCATION = "INSERT INTO Location(locationName,locationDesc,locationAddress,locationLatitude,locationLongitude) VALUES(?,?,?,?,?)";
        jdbc.update(INSET_LOCATION,
                location.getLocationName(),
                location.getLocationDesc(),
                location.getLocationAddress(),
                location.getLocationLatitude(),
                location.getLocationLongitude());
        int newInd = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        location.setLocationId(newInd);
        return location;
    }

    @Override
    public void updateLocation(Location location) {
        final String UPDATE_LOCATION = "UPDATE Location SET locationName = ?, locationDesc = ?, " +
                "locationAddress = ?, locationLatitude = ?, locationLongitude = ?  WHERE locationId = ?";
        jdbc.update(UPDATE_LOCATION,
                location.getLocationName(),
                location.getLocationDesc(),
                location.getLocationAddress(),
                location.getLocationLatitude(),
                location.getLocationLongitude(),
                location.getLocationId());
    }

    @Override
    //@Transactional
    public void deleteLocationById(int id) {
        final String DELETE_LOCATION = "DELETE FROM Location WHERE locationId = ?";
        jdbc.update(DELETE_LOCATION, id);

    }

    public static final class LocationMapper implements RowMapper<Location>{

        @Override
        public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
            Location location = new Location();
            location.setLocationId(rs.getInt("locationId"));
            location.setLocationName(rs.getString("locationName"));
            location.setLocationDesc(rs.getString("locationDesc"));
            location.setLocationAddress(rs.getString("locationAddress"));
            location.setLocationLatitude(rs.getString("locationLatitude"));
            location.setLocationLongitude(rs.getString("locationLongitude"));
            return location;
        }
    }
















}
