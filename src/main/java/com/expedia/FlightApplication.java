package com.expedia;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.expedia.util.DateConverter;

/**
 * The Class FlightApplication.
 */
@SuppressWarnings("deprecation")
@SpringBootApplication
public class FlightApplication extends WebMvcConfigurerAdapter {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(FlightApplication.class, args);
	}
	
	@Override
	public void addFormatters (FormatterRegistry registry) {
	        registry.addConverter(new DateConverter());
	}
}
