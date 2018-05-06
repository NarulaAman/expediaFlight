package com.expedia.domain;

import java.util.Date;

/**
 * The Class Flight.
 */
public class Flight {

	/** The name. */
	private String name;
	
	/** The operator. */
	private String operator;
	
	/** The departure time. */
	private Date departureTime;
	
	/** The departure city. */
	private String departureCity;
	
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	
	/**
	 * Sets the operator.
	 *
	 * @param operator the new operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	/**
	 * Gets the departure time.
	 *
	 * @return the departure time
	 */
	public Date getDepartureTime() {
		return departureTime;
	}
	
	/**
	 * Sets the departure time.
	 *
	 * @param departureTime the new departure time
	 */
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
	/**
	 * Gets the departure city.
	 *
	 * @return the departure city
	 */
	public String getDepartureCity() {
		return departureCity;
	}
	
	/**
	 * Sets the departure city.
	 *
	 * @param departureCity the new departure city
	 */
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Flight Name" + name + 
				"Departure Time"+ departureTime;
	}
}
