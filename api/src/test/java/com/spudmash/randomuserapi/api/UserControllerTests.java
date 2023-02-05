package com.spudmash.randomuserapi.api;

import java.util.ArrayList;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spudmash.randomuserapi.api.Dto.UserApiResponse;
import com.spudmash.randomuserapi.api.Dto.UserDto;
import com.spudmash.randomuserapi.api.services.UserService.UserService;
import com.spudmash.randomuserapi.api.services.UserService.models.Id;
import com.spudmash.randomuserapi.api.services.UserService.models.Location;
import com.spudmash.randomuserapi.api.services.UserService.models.Name;
import com.spudmash.randomuserapi.api.services.UserService.models.Picture;
import com.spudmash.randomuserapi.api.services.UserService.models.RandomUserResponse;
import com.spudmash.randomuserapi.api.services.UserService.models.User;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = true)
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class UserControllerTests implements WithAssertions {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private UserService userService;
    private RandomUserResponse mockRandomUserResponse;

    private UserApiResponse expectedResponse;

    @BeforeEach
    public void Init() {

        var testId = "123-456";
        var testFirstName = "John";
        var testLastName = "Doe";
        var testEmail = "johndoe@email.com";
        var testLocation = "Australia";
        var testProfileUrl = "http://test.com/profile.jpg";
        var testThumbnaillUrl = "http://test.com/thumnail.jpg";

        // Mock Service Model
        var mockUsers = new User[1];
        var mockUser = new User();

        var mockId = new Id();
        mockId.setValue(testId);
        mockUser.setId(mockId);

        var mockName = new Name();
        mockName.setFirst(testFirstName);
        mockName.setLast(testLastName);
        mockUser.setName(mockName);
        mockUser.setEmail(testEmail);

        var mockLocation = new Location();
        mockLocation.setCountry(testLocation);
        mockUser.setLocation(mockLocation);

        var mockPicture = new Picture();
        mockPicture.setLarge(testProfileUrl);
        mockPicture.setThumbnail(testThumbnaillUrl);
        mockUser.setPicture(mockPicture);

        mockUsers[0] = mockUser;

        mockRandomUserResponse = new RandomUserResponse();
        mockRandomUserResponse.setResults(mockUsers);

        // MOCK UserApiResponse
        expectedResponse = new UserApiResponse();
        var mockUserDto = new UserDto();
        mockUserDto.setId(testId);
        mockUserDto.setFirstName(testFirstName);
        mockUserDto.setLastName(testLastName);
        mockUserDto.setEmail(testEmail);
        mockUserDto.setCountry(testLocation);
        mockUserDto.setProfileImageUrl(testProfileUrl);
        mockUserDto.setThumbnailImageUrl(testThumbnaillUrl);

        var mockUserDtoList = new ArrayList<UserDto>();
        mockUserDtoList.add(mockUserDto);
        expectedResponse.setData(mockUserDtoList);
    }

    @Test
    public void UserController_getUser_return_response() throws Exception {
        BDDMockito.given(userService.getRandomUserResponse(ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
                .willReturn(mockRandomUserResponse);

        RequestBuilder request = MockMvcRequestBuilders.get("/user");

        MvcResult actualResponse = mockMvc.perform(request).andReturn();
        var actualResult = mapper
                .readValue(actualResponse
                        .getResponse()
                        .getContentAsString(), UserApiResponse.class);

        assertThat(actualResult)
                .usingRecursiveComparison() // performs field level comparison. See
                                            // https://assertj.github.io/doc/#assertj-core-recursive-comparison
                .isEqualTo(expectedResponse);
    }
}