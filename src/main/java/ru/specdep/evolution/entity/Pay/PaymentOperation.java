package ru.specdep.evolution.entity.Pay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentOperation {

    @JsonProperty
    private String account;

    @JsonProperty
    private String confirm;

    @JsonProperty
    private String fee;

    @JsonProperty
    private String confirmCode;

    @JsonProperty(value = "payment")
    private String status;

    public PaymentOperation() {
    }

    public PaymentOperation(String account, String confirm, String fee, String confirmCode, String status) {
        this.account = account;
        this.confirm = confirm;
        this.fee = fee;
        this.confirmCode = confirmCode;
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
