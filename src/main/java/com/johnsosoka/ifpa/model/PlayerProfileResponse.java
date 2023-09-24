package com.johnsosoka.ifpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlayerProfileResponse {

    @JsonProperty("player")
    private Player player;

    @JsonProperty("player_stats")
    private PlayerStats playerStats;

    @JsonProperty("championshipSeries")
    private List<ChampionshipSeries> championshipSeries;
}
