package com.expedia.persistence;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.expedia.domain.Flight;

// TODO: Auto-generated Javadoc
/**
 * The Class FlightDatabase.
 */
public class FlightDatabase {

	/** The flights. */
	private static Map<String,Flight> flights = new HashMap<>();
	
	/** The calendar. */
	private static Calendar calendar = Calendar.getInstance();

	static {

		calendar.set(2018, 04, 05, 7, 30, 00);

		Flight flight1 = new  Flight();
		flight1.setName("Air Canada 8099");
		flight1.setDepartureCity("Montreal");
		flight1.setOperator("AIR CANADA");
		flight1.setDepartureTime(calendar.getTime());
		flights.put(flight1.getName(), flight1);

		calendar.set(2018, 04, 04, 10, 30, 00);

		Flight flight2 = new  Flight();
		flight2.setName("United Airline 6115");
		flight2.setDepartureCity("New York");
		flight2.setOperator("UNITED AIRLINES");
		flight2.setDepartureTime(calendar.getTime());
		flights.put(flight2.getName(), flight2);
		
		calendar.set(2018, 04, 04, 12, 30, 00);

		Flight flight3 = new  Flight();
		flight3.setName("WestJet 6456");
		flight3.setDepartureCity("London");
		flight3.setOperator("WEST AIRWAYS");
		flight3.setDepartureTime(calendar.getTime());

		flights.put(flight3.getName(), flight3);
		
		calendar.set(2018, 04, 04, 15, 00, 00);

		Flight flight4 = new  Flight();
		flight4.setName("Delta 3833");
		flight4.setDepartureCity("Toronto");
		flight4.setOperator("DELTA");
		flight4.setDepartureTime(calendar.getTime());

		flights.put(flight4.getName(), flight4);
	}
	
	/**
	 * Gets the flights.
	 *
	 * @return the flights
	 */
	public static Map<String,Flight> getFlights() {
		return flights;
	}

}
