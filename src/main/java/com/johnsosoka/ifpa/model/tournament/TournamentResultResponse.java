package com.johnsosoka.ifpa.model.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TournamentResultResponse {

    @JsonProperty("tournament")
    private TournamentWrapper tournament;

}

