/*
*
* Сущность пары логин/пароль
*
 */

package ru.specdep.evolution.entity.Pay;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {

    @JsonProperty
    private String login;

    @JsonProperty
    private String password;

    public Credentials() {
    }

    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
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
