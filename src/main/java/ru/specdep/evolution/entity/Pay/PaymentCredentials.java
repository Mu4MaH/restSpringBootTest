/*
*
* Сущность реквизитов платежа
* для покупки паёв через кэшофф
*
 */

package ru.specdep.evolution.entity.Pay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentCredentials {
    @JsonProperty
    private String bik; //БИК банка

    @JsonProperty
    private String checkingAcc; // расчётный счёт

    @JsonProperty
    private String sum; //сумма платежа

    @JsonProperty
    private String reciever; //получатель платежа

    @JsonProperty
    private String inn; // ИНН

    @JsonProperty
    private String kpp; //КПП

    @JsonProperty
    private String corrAcc; //корреспондентский счёт

    @JsonProperty
    private String dest; // Назначение платежа

    public PaymentCredentials() {
    }

    public PaymentCredentials(String bik, String checkingAcc, String sum, String reciever, String inn, String kpp, String corrAcc, String dest) {
        this.bik = bik;
        this.checkingAcc = checkingAcc;
        this.sum = sum;
        this.reciever = reciever;
        this.inn = inn;
        this.kpp = kpp;
        this.corrAcc = corrAcc;
        this.dest = dest;
    }

    public String getBik() {
        return bik;
    }

    public void setBik(String bik) {
        this.bik = bik;
    }

    public String getCheckingAcc() {
        return checkingAcc;
    }

    public void setCheckingAcc(String checkingAcc) {
        this.checkingAcc = checkingAcc;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getCorrAcc() {
        return corrAcc;
    }

    public void setCorrAcc(String corrAcc) {
        this.corrAcc = corrAcc;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}
