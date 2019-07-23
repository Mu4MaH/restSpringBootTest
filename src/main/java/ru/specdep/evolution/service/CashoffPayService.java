package ru.specdep.evolution.service;

/*
    Сервис дёргает рест платежа у кэшофа, инициализируя платёж
 */

import ru.specdep.evolution.entity.Authorization.ReqBody;
import ru.specdep.evolution.entity.pay.CashoffPayRequest;
import ru.specdep.evolution.entity.pay.CashoffPayResponse;

public class CashoffPayService {

    ReqBody request = new ReqBody();

    public CashoffPayResponse makeThePayment(CashoffPayRequest request) {

        System.out.println(request.toString());

        return null;
    }


}
