package com.weather.demo.weatherapp.transformer;

import com.weather.demo.weatherapp.domain.CityWeather;
import com.weather.demo.weatherapp.entity.OpenWeatherResponseEntity;
import com.weather.demo.weatherapp.entity.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherTransformer {

    public CityWeather transformToDomain(final OpenWeatherResponseEntity entity) {
        return CityWeather.builder()
                .weather(entity.getWeather()[0].getMain())
                .details(entity.getWeather()[0].getDescription())
                .temp(entity.getMain().getTemp())
                .feels_like(entity.getMain().getFeels_like())
                .build();
    }

    public WeatherResponse transformToEntity(final CityWeather cityWeather) {
        return WeatherResponse.builder()
                .weather(cityWeather.getWeather())
                .details(cityWeather.getDetails())
                .temp(cityWeather.getTemp())
                .feels_like(cityWeather.getFeels_like()).build();
    }
}
