package com.johnsosoka.ifpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Player {
    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("initials")
    private String initials;

    @JsonProperty("age")
    private int age;

    @JsonProperty("excluded_flag")
    private String excludedFlag;

    @JsonProperty("ifpa_registered")
    private String ifpaRegistered;

    // TODO -- Field not mentioned in API Documentation
    @JsonProperty("gender")
    private String gender;
}