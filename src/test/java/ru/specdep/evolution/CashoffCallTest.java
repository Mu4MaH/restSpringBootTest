/*
*
*   Дёргаем ресты Кэшофф
*   с разными данными
*
 */

package ru.specdep.evolution;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.specdep.evolution.entity.Authorization.AuthorizationRequest;
import ru.specdep.evolution.entity.Authorization.ReqBody;
import ru.specdep.evolution.entity.Session.Session;
import ru.specdep.evolution.service.CashoffPayService;

import java.util.UUID;

@Service
public class CashoffCallTest {

    @Autowired
    CashoffPayService cashoffPayService;

    @Autowired
    AuthorizationRequest ar;

    @Autowired
    ReqBody reqBody;

    @Test
    public void initSession() {
        reqBody.setMethod("");
        reqBody.setService("infinitum2");
        reqBody.setRid(UUID.randomUUID().toString());
        ar.setRequestBody(reqBody);
        final String URL = "url=https://developer.cashoff.ru/api/json/";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.add("coAuth", cashoffPayService.coAuth("path", ar.toString()));
        HttpEntity<AuthorizationRequest> httpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Session output = restTemplate.postForObject(URL, httpEntity, Session.class);
        System.out.println(output);
    }

}
