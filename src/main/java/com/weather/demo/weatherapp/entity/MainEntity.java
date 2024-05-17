package com.weather.demo.weatherapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MainEntity {
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("feels_like")
    private Double feels_like;
    @JsonProperty("temp_min")
    private Double temp_min;
    @JsonProperty("temp_max")
    private Double temp_max;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("sea_level")
    private Double sea_level;
    @JsonProperty("grnd_level")
    private Double grnd_level;




}
