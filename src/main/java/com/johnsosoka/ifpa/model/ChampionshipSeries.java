package com.johnsosoka.ifpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChampionshipSeries {
    @JsonProperty("view_id")
    private String viewId;

    @JsonProperty("group_code")
    private String groupCode;

    @JsonProperty("group_name")
    private String groupName;

    @JsonProperty("rank")
    private String rank;

    @JsonProperty("country_name")
    private String countryName;
}
