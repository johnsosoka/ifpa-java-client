package com.johnsosoka.ifpa.model.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Tournament {
    @JsonProperty("tournament_id")
    private String tournamentId;

    @JsonProperty("tournament_name")
    private String tournamentName;

    // Missing from API Docs
    @JsonProperty("tournament_type")
    private String tournamentType;

    // TODO - Consider changing to boolean
    // Missing from API Docs
    @JsonProperty("prestige_flag")
    private String prestigeFlag;

    // TODO - Consider changing to boolean
    // Missing from API Docs
    @JsonProperty("periodic_flag")
    private String periodicFlag;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("contact_name")
    private String contactName;

    @JsonProperty("website")
    private String website;

    @JsonProperty("events")
    private List<TournamentEvent> events;
}
