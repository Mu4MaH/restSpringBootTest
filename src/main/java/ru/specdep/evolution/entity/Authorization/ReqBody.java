package ru.specdep.evolution.entity.Authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import ru.specdep.evolution.entity.Session.Session;

@Component
public class ReqBody {

    @JsonProperty("session")
    private Session session;

    @JsonProperty("auth-form")
    private AuthorizationForm authForm;

    @JsonProperty("@method")
    private String method;

    @JsonProperty("@service")
    private String service;

    @JsonProperty("@rid")
    private String rid;

    public ReqBody() {
    }

    public ReqBody(Session session, AuthorizationForm authForm, String method, String service, String rid) {
        this.session = session;
        this.authForm = authForm;
        this.method = method;
        this.service = service;
        this.rid = rid;
    }

    public AuthorizationForm getAuthForm() {
        return authForm;
    }

    public void setAuthForm(AuthorizationForm authForm) {
        this.authForm = authForm;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
/*

Тестовый запрос:

{
"request": {
    "auth-form": {
        "@save-password": false,
        "field": [{
            "@id": "login",
            "@value": "mylogin"
        },
        {
            "@id": "password",
            "@value": "mypassword"
        },]
        },
        "session": {
            "@id": "sessionid",
            "@create": "true",
            "@institution": "tcs"
        },
        "@method": "PARSING_DATA",
        "@service": "13569631",
        "@rid": "randomident"
        }
}
 */