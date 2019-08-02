package ru.specdep.evolution.entity.Pay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentInitializer {

    @JsonProperty
    private String pay;

    @JsonProperty
    private String sum;

    @JsonProperty(value = "UK_id")
    private String ukId;

    public PaymentInitializer() {
    }

    public PaymentInitializer(String pay, String sum, String ukId) {
        this.pay = pay;
        this.sum = sum;
        this.ukId = ukId;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getUkId() {
        return ukId;
    }

    public void setUkId(String ukId) {
        this.ukId = ukId;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
