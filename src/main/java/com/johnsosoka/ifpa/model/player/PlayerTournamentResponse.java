package com.johnsosoka.ifpa.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlayerTournamentResponse {
    @JsonProperty("player_id")
    private int playerId;

    @JsonProperty("results_count")
    private int resultsCount;

    @JsonProperty("results")
    private List<TournamentEvent> eventResults;
}