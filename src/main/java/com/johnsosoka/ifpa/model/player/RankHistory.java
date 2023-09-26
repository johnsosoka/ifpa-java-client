package com.johnsosoka.ifpa.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RankHistory {
    @JsonProperty("rank_date")
    private String rankDate;

    @JsonProperty("rank_position")
    private String rankPosition;

    @JsonProperty("wppr_points")
    private String wpprPoints;
}
