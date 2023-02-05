package com.spudmash.randomuserapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spudmash.randomuserapi.api.Dto.ErrorResponse;
import com.spudmash.randomuserapi.api.Dto.UserApiResponse;
import com.spudmash.randomuserapi.api.Dto.UserDto;
import com.spudmash.randomuserapi.api.services.UserService.*;
import com.spudmash.randomuserapi.api.services.UserService.models.*;

@RestController
public class UserController {

    // Dependency Injection of UserService
    @Autowired
    private IUserService userService;

    public UserController() {
    }

    /*
     * NOTE: query string params
     * "nat" maps to randomuser.me/api?nat=(au | us | fr)
     * "count" maps to randomuser.me/api?results=<integer>
     */
    @CrossOrigin(origins = {
            "http://localhost:3000",
            "http://localhost:5173",
            "http://localhost:8081"
    })
    @GetMapping("/user")
    public UserApiResponse getUser(
            @RequestParam(value = "nat", defaultValue = "au") String nationality,
            @RequestParam(value = "count", defaultValue = "1") String count) {

        UserApiResponse wipResponse = new UserApiResponse();

        try {
            RandomUserResponse response = userService.getRandomUserResponse(nationality, count);
            // Datamap
            var data = response.getResults();
            wipResponse.setData(UserDto.ConvertUserModelToUserDto(data)); // Datamapping using static function on DTO
        } catch (Exception e) {
            ErrorResponse errorWip = new ErrorResponse();
            errorWip.setMessage(e.getMessage());
            wipResponse.setError(errorWip);
        }

        return wipResponse;
    }
}
