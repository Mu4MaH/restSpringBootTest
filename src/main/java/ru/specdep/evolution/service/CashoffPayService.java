package ru.specdep.evolution.service;

/*
    Сервис дёргает рест платежа у кэшофа, инициализируя платёж
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.specdep.evolution.entity.Authorization.AuthorizationForm;
import ru.specdep.evolution.entity.Authorization.AuthorizationRequest;
import ru.specdep.evolution.entity.Authorization.ReqBody;
import ru.specdep.evolution.entity.Pay.CashoffPayRequest;
import ru.specdep.evolution.entity.Pay.CashoffPayResponse;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import ru.specdep.evolution.entity.Pay.PaymentCredentials;
import ru.specdep.evolution.entity.Pay.PaymentInitializer;
import ru.specdep.evolution.entity.Session.Session;

@Service
public class CashoffPayService {

    @Autowired
    ReqBody reqBody;

    private final String URL = "url=https://developer.cashoff.ru/api/json/";

    private String getHmacSHA1(String key, String data) {
        try {
            final String algorithm = "HmacSHA1";
            Mac hasher = Mac.getInstance(algorithm);
            hasher.init(new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), algorithm));
            byte[] hash = hasher.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(hash).toUpperCase();
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            return null;
        }
    }
    public String coAuth(String path, String request) {
        if (request.isEmpty()&&path.isEmpty()) return null;
        final String SERVICEID = "infinitum";
        String timestamp = String.valueOf(System.currentTimeMillis()/1000L);
        final String KEY = "310684cd36b8c8f6731c7909af31fdd9fc8a969b";
        String hashData = SERVICEID + String.valueOf(timestamp) + path + request;
        return SERVICEID + ":" + String.valueOf(timestamp) + ":" + getHmacSHA1(KEY, hashData);
    }

    public CashoffPayResponse makeThePayment(CashoffPayRequest request) {
        CashoffPayRequest payRequest = new CashoffPayRequest();
        AuthorizationForm authForm = new AuthorizationForm();
        Session session = new Session();
        session.setCreate("true");
        session.setId("");
        session.setInstitution("stub");
        reqBody.setSession(session);
        authForm.setField(null);


        return null;
    }

    public PaymentCredentials paymentInitlzrService(PaymentInitializer paymentInitializer) {
        //надо получить и отдать данные по айдишнику УК из переданного аргумента, пока статика для теста
        //список банков надло получить от кэшоф
        System.out.println(paymentInitializer.toString()); // покаж что получил!ммммммммммммммммм
        PaymentCredentials pc = new PaymentCredentials();
        final Map<String, String> banks = new HashMap<>();
        banks.put("Сбербанк", "sber");
        banks.put("Тинёк", "tcs");
        pc.setBik("044030704");
        pc.setCheckingAcc("40701810537000000131");
        pc.setCorrAcc("30101810200000000704");
        pc.setDest("Оплата паев ОПИФ Арсагера - СИ от Лущихин А. С. по заявке FP-08-0008854 от 24.07.19");
        pc.setInn("7840303927");
        pc.setKpp("783501001");
        pc.setReciever("ПАО \"УК \"Арсагера\"");
        pc.setBanks(banks);
        return pc;
    }

    public Map<String,String> accounts(String userId) {
        return new HashMap<>();
    }

    public Session initCashoffSession (Session session) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.add("coAuth", coAuth("path", session.toString()));
        HttpEntity<AuthorizationRequest> httpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Session output = restTemplate.postForObject(URL, httpEntity, Session.class);
        return output;
    }


}
