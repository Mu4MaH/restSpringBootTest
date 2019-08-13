/*
*
* Сущность пары логин/пароль
*
 */

package ru.specdep.evolution.entity.Pay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Credentials {

    @JsonProperty
    private String login;

    @JsonProperty
    private String password;

    @JsonProperty
    private String sms;

    public Credentials() {
    }

    public Credentials(String login, String password, String sms) {
        this.login = login;
        this.password = password;
        this.sms = sms;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
