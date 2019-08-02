package ru.specdep.evolution;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import ru.specdep.evolution.entity.Pay.Bank;
import ru.specdep.evolution.entity.Pay.Credentials;
import ru.specdep.evolution.entity.Pay.PaymentInitializer;
import ru.specdep.evolution.service.CashoffPayService;

import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CashoffPayServiceTest {

    CashoffPayService cashoffPayService = new CashoffPayService();
    ObjectMapper objectMapper = new ObjectMapper();
    List<Credentials> credentials = new ArrayList<Credentials>();

    @Test
    public void paymentInitlzrServiceTest() throws JsonProcessingException {
        PaymentInitializer paymentInitializer = new PaymentInitializer();
        paymentInitializer.setPay("true");
        paymentInitializer.setSum("100");
        paymentInitializer.setUkId("1213");
        String jsonString = objectMapper.writeValueAsString(cashoffPayService.paymentInitlzrService(paymentInitializer));
        System.out.println("Вышло: " + jsonString);
    }

    @Test
    public void bankSelectTest() throws JsonProcessingException {
        Bank bank = new Bank();
        bank.setBank("СБЕРБАНК");
        bank.setBankAlias("sber");
        System.out.println(objectMapper.writeValueAsString(bank));
    }

    @Test
    public void bankAuthTest() throws IOException {
//        credentials.add(objectMapper.readValue("{\"login\": \"login\", \"password\": \"password\"}", Credentials.class));
//        credentials.add(objectMapper.readValue("{\"sms\": \"sms\"}",Credentials.class));
        credentials.add(new Credentials("login3", "pass3", null));
        for (Credentials c : credentials) {
            System.out.println(objectMapper.writeValueAsString(c));
            if (c.getSms() != null) {
                System.out.println("Подтверждаем смс кодом");
            }
        }
    }
}
