package ru.specdep.evolution.service;
import javax.json.JsonObject;

/*
    Сервис дёргает рест платежа у кэшофа, инициализируя платёж
 */

import ru.specdep.evolution.entity.Authorization.AuthorizationRequest;
import ru.specdep.evolution.entity.pay.CashoffPayRequest;
import ru.specdep.evolution.entity.pay.CashoffPayResponse;

public class CashoffPayService {

    AuthorizationRequest authorizationRequest = new AuthorizationRequest();

    public CashoffPayResponse makeThePayment(CashoffPayRequest request) {

        System.out.println(request.toString());

        return null;
    }


}
