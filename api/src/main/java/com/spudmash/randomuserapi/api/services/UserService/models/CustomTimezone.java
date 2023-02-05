package com.spudmash.randomuserapi.api.services.UserService.models;

public class CustomTimezone {
    private String offset;
    private String description;
    public String getOffset() {
        return offset;
    }
    public void setOffset(String offset) {
        this.offset = offset;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    } 
}
