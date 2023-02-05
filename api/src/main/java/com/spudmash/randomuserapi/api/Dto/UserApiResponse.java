package com.spudmash.randomuserapi.api.Dto;

import java.util.ArrayList;

public class UserApiResponse {
    private ArrayList<UserDto> data;

    public ArrayList<UserDto> getData() {
        return data;
    }

    public void setData(ArrayList<UserDto> data) {
        this.data = data;
    }

    private ErrorResponse error;

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
