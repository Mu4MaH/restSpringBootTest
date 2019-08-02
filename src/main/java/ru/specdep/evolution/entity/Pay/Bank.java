package ru.specdep.evolution.entity.Pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Bank {

    @JsonProperty
    private String bank;

    @JsonProperty(value = "alias")
    private String bankAlias;

    public Bank() {
    }

    public Bank(String bank, String bankAlias) {
        this.bank = bank;
        this.bankAlias = bankAlias;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankAlias() {
        return bankAlias;
    }

    public void setBankAlias(String bankAlias) {
        this.bankAlias = bankAlias;
    }
}
