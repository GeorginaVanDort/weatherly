package com.intuition.weatherly.models;


public class Location {

    private String city;
    private String address;
    private Double latitude;
    private Double longitude;
    private String iconUrl;

    public Location () {}

    public Location (String city, String address, String iconUrl, Double latitude, Double longitude) {
        this.city = city;
        this.address = address;
        this.iconUrl = iconUrl;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getIconUrl() {
        return iconUrl;
    }
}
