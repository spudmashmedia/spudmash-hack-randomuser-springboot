package com.spudmash.randomuserapi.api.Dto;

import java.util.ArrayList;

import com.spudmash.randomuserapi.api.services.UserService.models.User;

public class UserDto {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String ProfileImageUrl;

    public String getProfileImageUrl() {
        return ProfileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        ProfileImageUrl = profileImageUrl;
    }

    public String ThumbnailImageUrl;

    public String getThumbnailImageUrl() {
        return ThumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        ThumbnailImageUrl = thumbnailImageUrl;
    }

    // Mapping Function
    public static UserDto ConvertUserModelToUserDto(User u) {
        var wipUserDto = new UserDto();

        if (u == null) {
            return null;
        }

        var id = u.getId();
        wipUserDto.setId(id.getValue());

        var usr = u.getName();
        wipUserDto.setFirstName(usr.getFirst());
        wipUserDto.setLastName(usr.getLast());
        wipUserDto.setEmail(u.getEmail());

        var loc = u.getLocation();
        if (loc != null)
            wipUserDto.setCountry(loc.getCountry());

        var picture = u.getPicture();
        if (picture != null) {
            wipUserDto.setProfileImageUrl(picture.getLarge());
            wipUserDto.setThumbnailImageUrl(picture.getThumbnail());
        }

        return wipUserDto;
    }

    public static ArrayList<UserDto> ConvertUserModelToUserDto(ArrayList<User> data) {
        var wipUserDtoList = new ArrayList<UserDto>();

        // fast fail
        if (data == null || data.size() == 0) {
            return wipUserDtoList;
        }

        for (User u : data) {
            wipUserDtoList.add(UserDto.ConvertUserModelToUserDto(u));
        }

        return wipUserDtoList;
    }

    public static ArrayList<UserDto> ConvertUserModelToUserDto(User[] data) {
        var wipUserDtoList = new ArrayList<UserDto>();

        // fast fail
        if (data == null || data.length == 0) {
            return wipUserDtoList;
        }

        for (User u : data) {
            wipUserDtoList.add(UserDto.ConvertUserModelToUserDto(u));
        }

        return wipUserDtoList;
    }
}
