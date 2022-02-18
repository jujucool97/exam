package com.example.exam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.exam.meteo.Weather;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class WeatherController {
        List<Weather> weathers = new ArrayList<Weather>();
        {
            weathers.add(new Weather("Marseille", "13008", "FR", "Il fait 19°C"));
            weathers.add(new Weather("Nice", "06100", "FR", "Il fait 16°C"));
            weathers.add(new Weather("Paris", "75000", "FR", "Il fait 11°C"));
            weathers.add(new Weather("Bordeau", "33000", "FR", "Il fait 13°C"));
        }

        @ApiOperation(value = "Get list of Weather in the System ", response = Iterable.class, tags = "getWeather")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Suceess|OK"),
                @ApiResponse(code = 401, message = "not authorized!"),
                @ApiResponse(code = 403, message = "forbidden!!!"),
                @ApiResponse(code = 404, message = "not found!!!") })

        @RequestMapping(value = "/getWeather")
        public List<Weather> getWeathers() {
            return weathers;
        }

        @ApiOperation(value = "Get specific Student in the System ", response = Weather.class, tags = "getVille")
        @RequestMapping(value = "/getWeather/{ville}")
        public Weather getVille(@PathVariable(value = "ville") String ville) {
            return weathers.stream().filter(x -> x.getVille().equalsIgnoreCase(ville)).collect(Collectors.toList()).get(0);
        }

        @RequestMapping(value = "/getWeather/{zip_code}")
        public List<Weather> getZip_code(@PathVariable(value = "zip_code") String zip_code) {
            return weathers.stream().filter(x -> x.getZip_code().equalsIgnoreCase(zip_code)).collect(Collectors.toList());
        }

        @RequestMapping(value = "/getWeather/{pays}")
        public List<Weather> getPays(@PathVariable(value = "pays") String pays) {
            return weathers.stream().filter(x -> x.getZip_code().equalsIgnoreCase(pays)).collect(Collectors.toList());
        }

        @RequestMapping(value = "/getWeather/{meteo}")
        public List<Weather> getMeteo(@PathVariable(value = "meteo") String meteo) {
            return weathers.stream().filter(x -> x.getZip_code().equalsIgnoreCase(meteo)).collect(Collectors.toList());
        }
}

