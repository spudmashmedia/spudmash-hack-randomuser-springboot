package com.spudmash.randomuserapi.api.services.UserService.models;

public class Location {
    private Street street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private GPSCoordinates coordinates;
    private CustomTimezone timezone;
    public Street getStreet() {
        return street;
    }
    public void setStreet(Street street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public GPSCoordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(GPSCoordinates coordinates) {
        this.coordinates = coordinates;
    }
    public CustomTimezone getTimezone() {
        return timezone;
    }
    public void setTimezone(CustomTimezone timezone) {
        this.timezone = timezone;
    }
}
