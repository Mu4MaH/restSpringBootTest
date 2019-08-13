package ru.specdep.evolution.restController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.specdep.evolution.enumerated.StatusHTTP;
import ru.specdep.evolution.entity.Authorization.AuthorizationRequest;
import ru.specdep.evolution.entity.Pay.*;
import ru.specdep.evolution.service.CashoffPayService;

import java.util.HashMap;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "/cashoff")
public class CashoffPayController {

    @PostMapping(path = "pay", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public AuthorizationRequest response(@RequestBody AuthorizationRequest payRequest) {
        return payRequest;
        //return cashoffPayService.makeThePayment(payRequest);
    }

    @PostMapping(path = "initializepay", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public PaymentCredentials payInitlrz(@RequestBody PaymentInitializer paymentInitializer) {
        CashoffPayService cashoffPayService = new CashoffPayService();
        return cashoffPayService.paymentInitlzrService(paymentInitializer);
    }

    @PostMapping(path = "bankselect", consumes = APPLICATION_JSON_UTF8_VALUE) //принимает логин/пароль от
    public String sdf (@RequestBody Bank bank) {
        return String.valueOf(StatusHTTP.STATUS_OK);
    }

    @PostMapping(path = "bankauth", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public AuthStatus bankAuth(@RequestBody Credentials credentials) {
        AuthStatus authStatus = new AuthStatus();
        //TODO: Отсюда сервис дёргает кэшофф с переданными данными учётки, если авторизация двухфакторная, то надо вернуть {"status": "sms"}
        authStatus.setAccounts(new HashMap<String, String>());
        authStatus.setStatus("granted");
        return authStatus;
    }

    @PostMapping(path = "account", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public PaymentOperation paymentOperation(@RequestBody PaymentOperation operation) {
        PaymentOperation output = new PaymentOperation();
        output.setStatus("success");
        return output;
    }

}
