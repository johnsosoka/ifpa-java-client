package com.johnsosoka.ifpa.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RatingHistory {
    @JsonProperty("rating_date")
    private String ratingDate;

    @JsonProperty("rating")
    private String rating;
}

