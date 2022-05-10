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
public class OrganizationDB implements OrganizationDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Organization getOrganizationById(int id) {
      try{
          final String SELECT_ORGANIZATION_BY_ID = "SELECT * FROM Super_Organization WHERE orgId = ?";
          Organization organization = jdbc.queryForObject(SELECT_ORGANIZATION_BY_ID, new OrganizationMapper(), id);
          return organization;
      }catch (DataAccessException ex) {
          return null;
      }
    }
    //not sure yet about this query...
    private List<SuperPerson> getSuperPersonPerOrganization(int id){
        final String SELECT_SUPER_PERSON = "SELECT * FROM SuperPerson WHERE superPersonId = ?";
        return jdbc.query(SELECT_SUPER_PERSON, new SuperPersonDB.SuperPersonMapper(), id);
    }

    @Override
    public List<Organization> getAllOrganizations() {
        final String SELECT_ALL_ORGANIZATIONS = "SELECT * FROM Organizations";
        List<Organization> organizationList = jdbc.query(SELECT_ALL_ORGANIZATIONS, new OrganizationMapper());
        return organizationList;
    }


    @Override
    @Transactional
    public Organization addOrganization(Organization organization) {
        final String INSERT_ORGANIZATION = "INSERT INTO Organizations(orgName,orgDescription,orgContactInfo) VALUES(?,?,?)";
        jdbc.update(INSERT_ORGANIZATION,
                organization.getOrgName(),
                organization.getOrgDescription(),
                organization.getOrgContactInfo());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        organization.setOrgId(newId);
        return organization;
    }


    @Override
    @Transactional
    public void updateOrganization(Organization organization) {
        final String UPDATE_ORGANIZATION = "UPDATE Organizations SET orgName = ?, orgDescription = ?, "
                + "orgContactInfo = ? WHERE orgId = ?";
        jdbc.update(UPDATE_ORGANIZATION,
                organization.getOrgName(),
                organization.getOrgDescription(),
                organization.getOrgContactInfo(),
                organization.getOrgId());

        final String DELETE_SUPER_ORGANIZATION = "DELETE FROM Super_Organization WHERE orgId = ?";
        jdbc.update(DELETE_SUPER_ORGANIZATION, organization.getOrgId());
    }

    @Override
    @Transactional
    public void deleteOrganizationById(int id) {
        final String DELETE_SUPER_ORGANIZATION = "DELETE FROM Super_Organization WHERE orgId = ?";
        jdbc.update(DELETE_SUPER_ORGANIZATION, id);

        final String DELETE_ORGANIZATION = "DELETE FROM Organizations WHERE orgId = ?";
        jdbc.update(DELETE_ORGANIZATION, id);
    }

    @Override
    public List<Organization> getOrganizationForSuperPerson(SuperPerson superPerson) {
        final String SELECT_ORGANIZATION_FOR_SUPER_PERSON = "SELECT o.* FROM Organizations o JOIN "
                + "Super_Organization so ON so.sightingId = so.orgId WHERE so.superPersonId = ?";
        List<Organization> organizations = jdbc.query(SELECT_ORGANIZATION_FOR_SUPER_PERSON,
                new OrganizationMapper(), superPerson.getSuperPersonId());
        return organizations;
    }

    public static final class OrganizationMapper implements RowMapper<Organization>{
        @Override
        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
            Organization organization = new Organization();
            organization.setOrgId(rs.getInt("orgId"));
            organization.setOrgName(rs.getString("orgName"));
            organization.setOrgDescription(rs.getString("orgDescription"));
            organization.setOrgContactInfo(rs.getString("orgContactInfo"));

            return organization;
        }
    }
}
