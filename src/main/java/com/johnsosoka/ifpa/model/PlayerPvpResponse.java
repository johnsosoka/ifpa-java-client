package com.johnsosoka.ifpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class PlayerPvpResponse {
    @JsonProperty("player_id")
    private int playerId;

    @JsonProperty("total_competitors")
    private int totalCompetitors;

    @JsonProperty("pvp")
    private List<PvpRecord> pvpRecords;
}

