package com.johnsosoka.ifpa.model.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TournamentWrapper {
    @JsonProperty("tournament_name")
    private String tournamentName;

    @JsonProperty("tournament_id")
    private String tournamentId;

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("event_date")
    private String eventDate;

    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("periodic_count")
    private Integer periodicCount;

    @JsonProperty("rating_strength")
    private String ratingStrength;

    @JsonProperty("ranking_strength")
    private String rankingStrength;

    @JsonProperty("base_value")
    private String baseValue;

    @JsonProperty("event_value")
    private String eventValue;

    @JsonProperty("results")
    private List<EventResult> results;

}
