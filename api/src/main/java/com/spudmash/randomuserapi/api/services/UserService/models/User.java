package com.spudmash.randomuserapi.api.services.UserService.models;

public class User {
    private String gender;
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    private Name name;
    public Name getName() {
        return name;
    }
    public void setName(Name name) {
        this.name = name;
    }
    private Location location;
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    private Login login;
    public Login getLogin() {
        return login;
    }
    public void setLogin(Login login) {
        this.login = login;
    }
    private DOB dob;
    public DOB getDob() {
        return dob;
    }
    public void setDob(DOB dob) {
        this.dob = dob;
    }
    private String phone;
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    private Id id;
    public Id getId() {
        return id;
    }
    public void setId(Id id) {
        this.id = id;
    }
    private Picture picture;
    public Picture getPicture() {
        return picture;
    }
    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    private String nat;
    public String getNat() {
        return this.nat;
    }
    public void setNat(String nat) {
        this.nat = nat;
    }

}
