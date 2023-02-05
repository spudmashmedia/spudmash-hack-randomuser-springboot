package com.spudmash.randomuserapi.api.services.UserService.models;

/*
 * RandomUserResponse - parent response wrapper
 */
public class RandomUserResponse {
    public RandomUserResponse() {};
    public RandomUserResponse(String errorMessage) { this.error = new ErrorResponse(errorMessage); }

    private ErrorResponse error;
    public ErrorResponse getError() {
        return error;
    }
    public void setError(ErrorResponse error) {
        this.error = error;
    }
    private Info info;
    private User[] results;

    public Info getInfo() { return this.info; }
    public void setInfo(Info info) {
        this.info = info;
    }

    public User[] getResults() { return this.results; }
    public void setResults(User[] users) { this.results = users;}
}
