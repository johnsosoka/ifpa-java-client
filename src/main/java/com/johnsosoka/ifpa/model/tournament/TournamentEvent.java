package com.johnsosoka.ifpa.model.tournament;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TournamentEvent {
    @JsonProperty("event_id")
    private String eventId;

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("event_date")
    private String eventDate;

    @JsonProperty("winner_player_id")
    private String winnerPlayerId;

    @JsonProperty("winner_first_name")
    private String winnerFirstName;

    @JsonProperty("winner_last_name")
    private String winnerLastName;
}
