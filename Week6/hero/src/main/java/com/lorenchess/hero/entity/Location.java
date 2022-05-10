package com.lorenchess.hero.entity;

import java.util.Objects;

public class Location {
    private int locationId;
    private String locationName;
    private String locationDesc;
    private String locationAddress;
    private String locationLatitude;
    private String locationLongitude;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getLocationId() == location.getLocationId() && getLocationName().equals(location.getLocationName()) && getLocationDesc().equals(location.getLocationDesc()) && getLocationAddress().equals(location.getLocationAddress()) && getLocationLatitude().equals(location.getLocationLatitude()) && getLocationLongitude().equals(location.getLocationLongitude());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocationId(), getLocationName(), getLocationDesc(), getLocationAddress(), getLocationLatitude(), getLocationLongitude());
    }
}
