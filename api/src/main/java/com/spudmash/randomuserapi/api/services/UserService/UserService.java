package com.spudmash.randomuserapi.api.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.spudmash.randomuserapi.api.services.UserService.models.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Mono;

// Mark Class as Service for Dependency Injection
@Service
public class UserService implements IUserService {
    private final String API_HOST = "https://randomuser.me";
    private WebClient getWebClient = WebClient.create(API_HOST);
    Logger logger;

    public UserService() {
        this.logger = LoggerFactory.getLogger(UserService.class);
    }

    public RandomUserResponse getRandomUserResponse(String nationality, String count) {
        return getWebClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/api")
                        .queryParam("nat", nationality)
                        .queryParam("results", count)
                        .build())
                .retrieve()
                .bodyToMono(RandomUserResponse.class)
                .doOnError(error -> this.logger.error("Something went wrong with data retrieval {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(new RandomUserResponse("Something went wrong")))
                .block();
    }
}
