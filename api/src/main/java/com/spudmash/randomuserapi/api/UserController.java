package com.spudmash.randomuserapi.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spudmash.randomuserapi.api.models.RandomUserResponse;

import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private final String API_HOST = "https://randomuser.me";

    private WebClient getWebClient = WebClient.create(API_HOST);

    Logger logger = LoggerFactory.getLogger(UserController.class);

    /*
     * NOTE: query string params
     * "nat" maps to randomuser.me/api?nat=(au | us | fr)
     * "count" maps to randomuser.me/api?results=<integer>
     */
    @GetMapping("/user")
    public RandomUserResponse getUser(
        @RequestParam(value="nat", defaultValue = "au") String nationality,
        @RequestParam(value="count", defaultValue="1") String count){

        return getWebClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/api")
                    .queryParam("nat", nationality)
                    .queryParam("results", count)
                    .build())
                .retrieve()
                .bodyToMono(RandomUserResponse.class)
                .doOnError(error -> logger.error("Something went wrong with data retrieval {}", error.getMessage()))
                .onErrorResume(error -> Mono.just(new RandomUserResponse("Something went wrong")))
                .block();
    }
}
