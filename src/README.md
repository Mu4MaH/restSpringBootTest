Алгоритм рабоыт следующий:
1) Фронт дёргает CashoffPayRequestController инициализирую платёж
2) CashoffPayRequestController дёргает SessionInitlzr и получает айди живой сессии.
3) CashoffPayRequestController с айди активной сессии дёргает рест у Кэшофф 
для авторизации пользователя у банка.
4) CashoffPayRequestController дёргает рест у Кэшофф для получения списка продуктов 
для проведения платежа, Кэшофф возвращаетсписок продуктов, который актуален
для проведения платежа
5) CashoffPayRequestController дёргает рест Кэшофф с реквизитами для\ платежа
6) провайдер услуги подтверждает платёж кодом, код надо отослать в рест Кэшоф
7) Получение статуса платежа. Какая-то муть в api доке, надо уточнить. 

```
Пример запроса: 
{
    "request": {
        "auth-form": {
            "@save-password": "false",
            "field": [
                {
                    "@id": "login",
                    "@value": "test1"
                },
                {
                    "@id": "password",
                    "@value": "test1"
                }
            ]
        },
        "session": {
            "@id": "id1",
            "@create": "true",
            "@institution": "tcs"
        },
        "@method": "PARSING_DATA",
        "@service": "infinitum2",
        "@rid": "aaaa-bbbb-cccc-eeee-ffff"
    }
}
```