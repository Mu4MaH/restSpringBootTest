
/*
*
* Ответ на пересылку логин/пароля при авторизации
*
 */

package ru.specdep.evolution.entity.Pay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthStatus {

    @JsonProperty
    private String status;

    @JsonProperty
    private Map<String, String> accounts;

    public AuthStatus() {
    }

    public AuthStatus(String status, Map<String, String> accounts) {
        this.status = status;
        this.accounts = accounts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, String> accounts) {
        this.accounts = accounts;
    }
}
