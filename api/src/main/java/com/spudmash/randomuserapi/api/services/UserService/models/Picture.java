package com.spudmash.randomuserapi.api.services.UserService.models;

public class Picture {
    private String large;
    public String getLarge() {
        return large;
    }
    public void setLarge(String large) {
        this.large = large;
    }
    private String medium;
    public String getMedium() {
        return medium;
    }
    public void setMedium(String medium) {
        this.medium = medium;
    }
    private String thumbnail;
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
