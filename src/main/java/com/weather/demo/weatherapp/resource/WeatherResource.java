package com.weather.demo.weatherapp.resource;

import com.weather.demo.weatherapp.domain.WeatherRequestDetails;
import com.weather.demo.weatherapp.entity.WeatherResponse;
import com.weather.demo.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather-app")
public class WeatherResource {

    private WeatherService weatherService;

    @Autowired
    public WeatherResource(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public @ResponseBody WeatherResponse weather(@PathVariable("city") String city) throws Exception {
        final WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
                .city(city)
                .build();

        return weatherService.getWeather(weatherRequestDetails);
    }
}
