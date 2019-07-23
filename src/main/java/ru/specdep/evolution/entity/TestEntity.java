package ru.specdep.evolution.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestEntity {
    @JsonProperty("@method")
    String method;

    @JsonProperty("@id")
    String id;

    @JsonProperty("@service")
    String service;
}
