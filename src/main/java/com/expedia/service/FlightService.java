package com.expedia.service;

import java.util.Collection;
import java.util.Date;

import com.expedia.domain.Flight;

/**
 * The Interface FlightService.
 */
public interface FlightService {

	/**
	 * Flights.
	 *
	 * @return the collection
	 */
	public Collection<Flight> flights();
	
	/**
	 * Flight by name.
	 *
	 * @param name the name
	 * @return the flight
	 */
	public Flight flightByName(String name);
	
	/**
	 * Flights by date.
	 *
	 * @param date the date
	 * @return the collection
	 */
	public Collection<Flight> flightsByDate(Date date);
	
	/**
	 * Flights by departure city.
	 *
	 * @param cityName the city name
	 * @return the collection
	 */
	public Collection<Flight> flightsByDepartureCity(String cityName);
	
	/**
	 * Flights by time.
	 * Queries flights from 5 hours prior to the time and 
	 * until 5 hours later on the current date.
	 *
	 * @param time the time
	 * @return the collection
	 */
	public Collection<Flight> flightsByTime(String time);
	
	/**
	 * Flights by date time.
	 *
	 * @param date the date
	 * @param time the time
	 * @return the collection
	 */
	public Collection<Flight> flightsByDateTime(Date date, String time);
	
}
