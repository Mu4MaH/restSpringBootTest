package ru.specdep.evolution.entity.Pay;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.specdep.evolution.entity.Session.Session;

import javax.json.JsonObject;

public class CashoffPayRequestBody {

    @JsonProperty(value = "@method")
    private String method;

    @JsonProperty(value = "@rid")
    private String rid;

    @JsonProperty(value = "@service")
    private String service;

    @JsonProperty
    private Session session;

    @JsonProperty
    private JsonObject parse;

    public CashoffPayRequestBody() {
    }

    public CashoffPayRequestBody(String method, String rid, String service, Session session, JsonObject parse) {
        this.method = method;
        this.rid = rid;
        this.service = service;
        this.session = session;
        this.parse = parse;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public JsonObject getParse() {
        return parse;
    }

    public void setParse(JsonObject parse) {
        this.parse = parse;
    }
}
