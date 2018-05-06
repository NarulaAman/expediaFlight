package com.expedia.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expedia.domain.Flight;
import com.expedia.service.FlightService;

/**
 * The Class FlightController.
 */
@RestController
@RequestMapping(value = "/flight", produces = "application/json")
public class FlightController {

	/** The flight service. */
	@Autowired
	@Qualifier("flightService")
	private FlightService flightService;
	
	/**
	 * Instantiates a new flight controller.
	 */
	public FlightController() {
	}
	
	/**
	 * Queries all flights 
	 * or
	 * City departing from
	 * Time between 5 hours prior and 5 hours late on today's date.
	 * Date departing on
	 *
	 * @param date the date
	 * @param time the time
	 * @return the collection
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Flight> flights(
			@RequestParam(value="date", required=false) Date date,
			@RequestParam(value="time", required=false) String time,
			@RequestParam(value="city", required=false) String city) {
		if(date == null && time == null && city == null) {
			return flightService.flights();
		} else if(time == null && city == null) {
			return flightService.flightsByDate(date);	
		} else if(date == null && city == null) {
			return flightService.flightsByTime(time);
		} else if(date == null && time == null){
			return flightService.flightsByDepartureCity(city);
		} else {
			return flightService.flightsByDateTime(date,time); 
		}
		
	}
	
	/**
	 * Queries flight by flight name.
	 *
	 * @param name the name
	 * @return the flight
	 */
	@RequestMapping(value="/{name}", method= RequestMethod.GET)
	public Flight flightByName(@PathVariable String name) {
		return flightService.flightByName(name);
	}
	
	
	
	
}
