package ru.specdep.evolution.entity.Session;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Session {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@create")
    private String create;

    @JsonProperty("@institution")
    private String institution;

    public Session(String id, String create, String institution) {
        this.id = id;
        this.create = create;
        this.institution = institution;
    }

    public Session() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(String create) {
        this.create = create;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
