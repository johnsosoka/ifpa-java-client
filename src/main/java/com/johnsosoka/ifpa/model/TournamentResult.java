package com.johnsosoka.ifpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TournamentResult {

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("tournament_name")
    private String tournamentName;

    @JsonProperty("tournament_id")
    private String tournamentId;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("periodic_flag")
    private String periodicFlag;

    @JsonProperty("wppr_state")
    private String wpprState;

}
