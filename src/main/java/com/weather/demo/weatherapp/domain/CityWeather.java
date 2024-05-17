package com.weather.demo.weatherapp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CityWeather {
    private String weather;
    private String details;
    private Double temp;
    private Double feels_like;

}
