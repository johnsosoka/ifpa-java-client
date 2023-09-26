package com.johnsosoka.ifpa.model.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TournamentResponse {

    @JsonProperty("tournament")
    private Tournament tournament;
}

