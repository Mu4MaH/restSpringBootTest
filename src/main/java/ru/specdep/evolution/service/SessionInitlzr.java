package ru.specdep.evolution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import ru.specdep.evolution.entity.Authorization.AuthorizationRequest;
import ru.specdep.evolution.entity.Authorization.ReqBody;

/*
Создаёт и возвращает новую сессию на стороне кэшофф
 */
//TODO
public class SessionInitlzr {

    @Autowired
    private CashoffPayService cashoffPayService;

    public String sessionInitlz(ReqBody reqBody){
        String session = "";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.add("coAuth", cashoffPayService.coAuth("path", reqBody.toString()));
        HttpEntity<AuthorizationRequest> httpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate template = new RestTemplate();
        return session;
    }
}
