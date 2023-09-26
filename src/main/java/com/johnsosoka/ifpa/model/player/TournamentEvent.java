package com.johnsosoka.ifpa.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TournamentEvent {
    @JsonProperty("tournament_id")
    private String tournamentId;

    @JsonProperty("tournament_name")
    private String tournamentName;

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("event_date")
    private String eventDate;

    @JsonProperty("position")
    private String position;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("periodic_flag")
    private String periodicFlag;

    @JsonProperty("wppr_state")
    private String wpprState;

    @JsonProperty("original_points")
    private String originalPoints;

    @JsonProperty("current_points")
    private String currentPoints;
}

