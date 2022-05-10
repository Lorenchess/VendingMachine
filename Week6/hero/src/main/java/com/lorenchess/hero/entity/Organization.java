package com.lorenchess.hero.entity;

import java.util.List;
import java.util.Objects;

public class Organization {
    private int orgId;
    private String orgName;
    private String orgDescription;
    private String orgContactInfo;

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public String getOrgContactInfo() {
        return orgContactInfo;
    }

    public void setOrgContactInfo(String orgContactInfo) {
        this.orgContactInfo = orgContactInfo;
    }

}
