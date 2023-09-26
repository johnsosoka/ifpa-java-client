package com.johnsosoka.ifpa.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class CountryDirectorSearchResponse {
    @JsonProperty("query")
    private String query;

    @JsonProperty("search")
    private List<CountryDirector> countryDirectors;
}
