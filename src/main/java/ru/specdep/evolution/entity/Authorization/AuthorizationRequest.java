package ru.specdep.evolution.entity.Authorization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationRequest {

    @JsonProperty("request")
    private ReqBody requestBody;

    public ReqBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(ReqBody requestBody) {
        this.requestBody = requestBody;
    }

    public AuthorizationRequest() {
    }

    public AuthorizationRequest(ReqBody requestBody) {
        this.requestBody = requestBody;
    }
}
