package com.johnsosoka.ifpa.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class PlayerHistoryResponse {

    @JsonProperty("player")
    private BasicPlayer player;

    @JsonProperty("rank_history")
    private List<RankHistory> rankHistory;

    @JsonProperty("rating_history")
    private List<RatingHistory> ratingHistory;
}

