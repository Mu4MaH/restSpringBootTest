package ru.specdep.evolution.entity.Authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationForm {

    @JsonProperty("@save-password")
    private String savePassword;

    @JsonProperty("field")
    private CredentialsField[] field;

    public AuthorizationForm() {
    }

    public AuthorizationForm(String savePassword, CredentialsField[] field) {
        this.savePassword = savePassword;
        this.field = field;
    }

    public String getSavePassword() {
        return savePassword;
    }

    public void setSavePassword(String savePassword) {
        this.savePassword = savePassword;
    }

    public CredentialsField[] getField() {
        return field;
    }

    public void setField(CredentialsField[] field) {
        this.field = field;
    }
}
