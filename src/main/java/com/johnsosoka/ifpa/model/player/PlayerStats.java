package com.johnsosoka.ifpa.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlayerStats {
    @JsonProperty("current_wppr_rank")
    private String currentWpprRank;

    @JsonProperty("last_month_rank")
    private String lastMonthRank;

    @JsonProperty("last_year_rank")
    private String lastYearRank;

    @JsonProperty("highest_rank")
    private String highestRank;

    @JsonProperty("highest_rank_date")
    private String highestRankDate;

    @JsonProperty("current_wppr_value")
    private String currentWpprValue;

    @JsonProperty("wppr_points_all_time")
    private String wpprPointsAllTime;

    @JsonProperty("best_finish")
    private String bestFinish;

    @JsonProperty("best_finish_count")
    private String bestFinishCount;

    @JsonProperty("average_finish")
    private String averageFinish;

    @JsonProperty("average_finish_last_year")
    private String averageFinishLastYear;

    @JsonProperty("total_events_all_time")
    private String totalEventsAllTime;

    @JsonProperty("total_active_events")
    private String totalActiveEvents;

    @JsonProperty("total_events_away")
    private String totalEventsAway;

    @JsonProperty("ratings_rank")
    private String ratingsRank;

    @JsonProperty("ratings_value")
    private String ratingsValue;

    @JsonProperty("efficiency_rank")
    private double efficiencyRank;

    @JsonProperty("efficiency_value")
    private double efficiencyValue;
}
