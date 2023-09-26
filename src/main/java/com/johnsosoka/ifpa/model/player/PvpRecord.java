package com.johnsosoka.ifpa.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PvpRecord {
    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("win_count")
    private String winCount;

    @JsonProperty("loss_count")
    private String lossCount;

    @JsonProperty("tie_count")
    private String tieCount;
}
