package ru.specdep.evolution.service;

/*
    Сервис дёргает рест платежа у кэшофа, инициализируя платёж
 */

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import ru.specdep.evolution.entity.Authorization.AuthorizationRequest;
import ru.specdep.evolution.entity.Pay.CashoffPayRequest;
import ru.specdep.evolution.entity.Pay.CashoffPayResponse;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import ru.specdep.evolution.entity.Pay.PaymentCredentials;
import ru.specdep.evolution.entity.Pay.PaymentInitializer;


public class CashoffPayService {

    String getHmacSHA1(String key, String data) {
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
    private String coAuth(String path, String request) {
        if (request.isEmpty()&&path.isEmpty()) return null;
        final String SERVICEID = "infinitum";
        String timestamp = String.valueOf(System.currentTimeMillis()/1000L);
        final String KEY = "310684cd36b8c8f6731c7909af31fdd9fc8a969b";
        String hashData = SERVICEID + String.valueOf(timestamp) + path + request;
        return SERVICEID + ":" + String.valueOf(timestamp) + ":" + getHmacSHA1(KEY, hashData);
    }

    public CashoffPayResponse makeThePayment(CashoffPayRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<AuthorizationRequest> httpEntity = new HttpEntity<>(httpHeaders);
        return null;
    }

    public PaymentCredentials paymentInitlzrService (PaymentInitializer paymentInitializer) {
        PaymentCredentials pc = new PaymentCredentials();
        pc.setBik("044030704");
        pc.setCheckingAcc("40701810537000000131");
        pc.setCorrAcc("30101810200000000704");
        pc.setDest("Оплата паев ОПИФ Арсагера - СИ от Лущихин А. С. по заявке FP-08-0008854 от 24.07.19");
        pc.setInn("7840303927");
        pc.setKpp("783501001");
        pc.setReciever("ПАО \"УК \"Арсагера\"");
        return pc;
    }


}
