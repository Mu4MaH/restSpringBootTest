package ru.specdep.evolution.entity.Session;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class NewSessionRequest {
    public void test() {
        HttpHeaders headers = new HttpHeaders();
        String url = "";
        RestTemplate restTemplate = new RestTemplate();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}
