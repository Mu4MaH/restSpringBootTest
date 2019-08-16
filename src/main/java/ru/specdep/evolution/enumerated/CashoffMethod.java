package ru.specdep.evolution.enumerated;

public enum CashoffMethod {
    CREATE_PROFILE("control/create-profile/"),
    REMOVE_PROFILE("control/remove-profile/"),
    NEW_WEB_SESSION("control/new-web-session/"),
    PARSING_DATA_R("control/parsing-data-r/"),
    GET_PAYMENT_PRODUCTS("control/get-payment-products/"),
    PAYMENT_INITIAL("control/payment-initial/"),
    PAYMENT_CONFIRM("control/payment-confirm/");


    private String url;

    private CashoffMethod(String url) {
        this.url = url;
    };

    public String getURL() {
        return url;
    }

}
