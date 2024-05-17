package com.weather.demo.weatherapp.service;

import com.weather.demo.weatherapp.domain.CityCoordinates;
import com.weather.demo.weatherapp.domain.CityWeather;
import com.weather.demo.weatherapp.domain.WeatherRequestDetails;
import com.weather.demo.weatherapp.entity.WeatherResponse;
import com.weather.demo.weatherapp.provider.GeocodingProvider;
import com.weather.demo.weatherapp.provider.WeatherProvider;
import com.weather.demo.weatherapp.transformer.GeoCodingCoordinatesTransformer;
import com.weather.demo.weatherapp.transformer.OpenWeatherTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private GeocodingProvider geocodingProvider;
    private GeoCodingCoordinatesTransformer geoCodingCoordinatesTransformer;
    private WeatherProvider weatherProvider;
    private OpenWeatherTransformer openWeatherTransformer;

    @Autowired
    public WeatherService(final GeocodingProvider geocodingProvider,
                          final GeoCodingCoordinatesTransformer geoCodingCoordinatesTransformer,
                          final WeatherProvider weatherProvider,
                          final OpenWeatherTransformer openWeatherTransformer) {
        this.geocodingProvider = geocodingProvider;
        this.geoCodingCoordinatesTransformer = geoCodingCoordinatesTransformer;
        this.weatherProvider = weatherProvider;
        this.openWeatherTransformer = openWeatherTransformer;
    }

    public WeatherResponse getWeather(final WeatherRequestDetails weatherRequestDetails) throws Exception {

//        get latitude and longitude
        final CityCoordinates cityCoordinates = geoCodingCoordinatesTransformer.
                transformToDomain(geocodingProvider.getCoordinates(weatherRequestDetails));

        final CityWeather cityWeather = openWeatherTransformer.transformToDomain(weatherProvider.getWeather(cityCoordinates));


        return openWeatherTransformer.transformToEntity(cityWeather);
    }
}
