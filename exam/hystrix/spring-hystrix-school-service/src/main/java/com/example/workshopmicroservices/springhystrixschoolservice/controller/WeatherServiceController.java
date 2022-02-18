package com.example.workshopmicroservices.springhystrixschoolservice.controller;

import com.example.workshopmicroservices.springhystrixschoolservice.delegate.WeatherServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherServiceController {
	
	@Autowired
	WeatherServiceDelegate weatherServiceDelegate;

	@RequestMapping(value = "/getVille/{Ville}", method = RequestMethod.GET)
	public String getStudents(@PathVariable String ville) {
		System.out.println("Going to call student service to get data!");
		return weatherServiceDelegate.callWeatherServiceAndGetData(ville);
	}
	
}
