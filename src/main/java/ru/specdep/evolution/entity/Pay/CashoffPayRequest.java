package ru.specdep.evolution.entity.Pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.specdep.evolution.entity.Authorization.ReqBody;

public class CashoffPayRequest {

    @JsonProperty
    private ReqBody request;

    public CashoffPayRequest() {
    }

    public ReqBody getRequest() {
        return request;
    }

    public void setRequest(ReqBody request) {
        this.request = request;
    }

    public CashoffPayRequest(ReqBody request) {
        this.request = request;
    }
}
