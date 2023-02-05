package com.spudmash.randomuserapi.api.services.UserService;

import com.spudmash.randomuserapi.api.services.UserService.models.RandomUserResponse;

public interface IUserService {
    public RandomUserResponse getRandomUserResponse(String nationality, String count);
}