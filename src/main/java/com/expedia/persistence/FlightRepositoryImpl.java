package com.expedia.persistence;

import static com.expedia.persistence.FlightDatabase.getFlights;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.expedia.domain.Flight;
import com.expedia.exception.BadRequestException;
import com.expedia.exception.FlightNotFoundException;
import com.expedia.util.FlightUtils;

/**
 * The Class FlightRepositoryImpl.
 */
@Repository("flightRepo")
public class FlightRepositoryImpl implements FlightRepository {
	
	/** The Constant logger. */
	private final static Logger logger = LogManager.getLogger();
	

	@Override
	public Collection<Flight> flights() {
		return getFlights().values().
				stream().
				collect(Collectors.toList());
	}
	
	@Override
	public Flight flightByName(String name) {
		Flight flight = getFlights().get(name);
		if(flight == null) {
			throw new FlightNotFoundException("Flight "+name+" is not found");
		} else {
			return flight;
		}
	}

	@Override
	public Collection<Flight> flightsByDate(Date date) {	
		Collection<Flight> flightList = getFlights().values().stream().
				filter(flight -> FlightUtils.isSameDay(flight.getDepartureTime(),date)).
				collect(Collectors.toList());
		
		if(flightList.isEmpty()) {
			throw new FlightNotFoundException("There is no flight departing on " + date);
		} else {
			return flightList;
		}
	}

	@Override
	public Collection<Flight> flightByTime(String time) {
		logger.info("Inside flightByTime");
		
		int hour ;
		int minute;
		
		String args[] = time.split(":");
		
		if(args.length != 2) {
			throw new BadRequestException("Invalid time format, supported time format hh:mm");
		} else {
			try {
				hour = Integer.parseInt(args[0]);
				minute = Integer.parseInt(args[1]);
			} catch(NumberFormatException e) {
				throw new BadRequestException("Invalid time format, supported time format hh:mm");
			}
		}
		
		Calendar cal = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.set(cal.get(Calendar.YEAR), 
				cal.get(Calendar.MONTH), 
				cal.get(Calendar.DATE), 
				hour, minute);
		
		calendar.add(Calendar.HOUR_OF_DAY, -5);
		Date timeBfr5hrs = calendar.getTime();
		
		calendar.add(Calendar.HOUR_OF_DAY, 10);
		Date timeAft5hrs = calendar.getTime();	
		
		
		Collection<Flight> flightList = getFlights().values().stream().
				filter(flight -> flight.getDepartureTime().after(timeBfr5hrs) && 
						flight.getDepartureTime().before(timeAft5hrs)).
				collect(Collectors.toList());
		
		if(!flightList.isEmpty()) {
			return flightList;
		} else {
			throw new FlightNotFoundException("There is no flight available between "+ timeBfr5hrs+" and "+ timeAft5hrs);
		}
		
	}

	@Override
	public Collection<Flight> flightByCity(String city) {
		Collection<Flight> flightList = getFlights().values().stream().
				filter(flight -> flight.getDepartureCity().equalsIgnoreCase(city)).
				collect(Collectors.toList());
		
		if(flightList.isEmpty()) {
			throw new FlightNotFoundException("There is no flight departing from " + city);
		} else {
			return flightList;
		}
	}
}
