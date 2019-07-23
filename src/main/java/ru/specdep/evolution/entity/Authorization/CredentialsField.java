package ru.specdep.evolution.entity.Authorization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialsField {

    @JsonProperty("@id")
    String id;

    @JsonProperty("@value")
    String value;

    public CredentialsField() {
    }

    public CredentialsField(String id, String value) {
        this.id = id;
        this.value = value;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
