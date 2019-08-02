package ru.specdep.evolution.Enumerated;

public enum StatusHTTP {
    STATUS_OK ("200");

    private String status;

    private StatusHTTP(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
