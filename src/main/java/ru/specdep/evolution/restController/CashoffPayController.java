package ru.specdep.evolution.restController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.specdep.evolution.entity.Authorization.AuthorizationRequest;
import ru.specdep.evolution.entity.Pay.Credentials;
import ru.specdep.evolution.entity.Pay.PaymentCredentials;
import ru.specdep.evolution.entity.Pay.PaymentInitializer;
import ru.specdep.evolution.service.CashoffPayService;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "/cashoff")
public class CashoffPayController {

    private CashoffPayService cashoffPayService;

    @PostMapping(path = "pay", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public AuthorizationRequest response(@RequestBody AuthorizationRequest payRequest) {
        return payRequest;
        //return cashoffPayService.makeThePayment(payRequest);

    }

    @PostMapping(path = "initializepay", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public PaymentCredentials payInitlrz (@RequestBody PaymentInitializer paymentInitializer) {
        CashoffPayService cashoffPayService = new CashoffPayService();
        return cashoffPayService.paymentInitlzrService(paymentInitializer);
    }
}
