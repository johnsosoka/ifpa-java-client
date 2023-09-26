package com.johnsosoka.ifpa.model.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EventResult {
    @JsonProperty("position")
    private String position;

    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("rank")
    private String rank;

    @JsonProperty("wppr_value")
    private String wpprValue;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("ratings_value")
    private String ratingsValue;

    @JsonProperty("points")
    private String points;

    @JsonProperty("wppr_rank")
    private String wpprRank;
}

