package com.johnsosoka.ifpa.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Player extends BasicPlayer {

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