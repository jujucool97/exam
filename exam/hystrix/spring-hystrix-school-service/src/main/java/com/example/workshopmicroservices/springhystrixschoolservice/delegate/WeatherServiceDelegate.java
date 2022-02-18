package com.example.workshopmicroservices.springhystrixschoolservice.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WeatherServiceDelegate {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
	public String callWeatherServiceAndGetData(String ville) {
		System.out.println("Getting School details for " + ville);
		String response = restTemplate
				.exchange("http://localhost:8098/getStudentDetailsForSchool/{schoolname}"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, ville).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - School Name -  " + ville + " :::  Student Details " + response + " -  " + new Date();
	}
	
	@SuppressWarnings("unused")
	private String callStudentServiceAndGetData_Fallback(String ville) {
		System.out.println("Student Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Student Service at this moment. Service will be back shortly - " + new Date();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
