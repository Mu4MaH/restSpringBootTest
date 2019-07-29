package ru.specdep.evolution.entity.Pay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentInitializer {

    @JsonProperty
    private String pay;

    @JsonProperty
    private String userId;

    public PaymentInitializer() {
    }

    public PaymentInitializer(String pay, String userId) {
        this.pay = pay;
        this.userId = userId;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
