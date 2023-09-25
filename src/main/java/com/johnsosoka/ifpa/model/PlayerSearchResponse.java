package com.johnsosoka.ifpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class PlayerSearchResponse {
    @JsonProperty("query")
    private String query;

    @JsonProperty("search")
    private List<PlayerSearchResult> searchResults;
}

