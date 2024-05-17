package com.weather.demo.weatherapp.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WeatherResponse {

    private String weather;
    private String details;
    private Double temp;
    private Double feels_like;
}
