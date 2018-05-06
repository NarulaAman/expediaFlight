package com.expedia.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expedia.domain.Flight;
import com.expedia.persistence.FlightRepository;

/**
 * The Class FlightServiceImpl.
 */
@Service("flightService")
public class FlightServiceImpl implements FlightService {

	/** The flight repo. */
	@Autowired
	private FlightRepository flightRepo;
	
	@Override
	public Collection<Flight> flights() {
		return flightRepo.flights();
	}

	@Override
	public Flight flightByName(String name) {
		return flightRepo.flightByName(name);
	}

	@Override
	public Collection<Flight> flightsByDate(Date date) {
		 return flightRepo.flightsByDate(date);
	}

	@Override
	public Collection<Flight> flightsByDepartureCity(String cityName) {
		return flightRepo.flightByCity(cityName);
	}

	@Override
	public Collection<Flight> flightsByTime(String time) {
		return flightRepo.flightByTime(time);
	}

	@Override
	public Collection<Flight> flightsByDateTime(Date date, String time) {
		return null;
	}

	

}
