package com.expedia.persistence;

import java.util.Collection;
import java.util.Date;

import com.expedia.domain.Flight;

/**
 * The Interface FlightRepository.
 */
public interface FlightRepository {

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
	 * Flight by time.
	 * Considers the current date i.e. Today's date
	 *
	 * @param time the time
	 * @return the collection
	 */
	public Collection<Flight> flightByTime(String time);
	
	/**
	 * Flight by city.
	 *
	 * @param city the city
	 * @return the collection
	 */
	public Collection<Flight> flightByCity(String city);
	
}
