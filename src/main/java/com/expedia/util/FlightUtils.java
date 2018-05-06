package com.expedia.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class FlightUtils.
 */
public class FlightUtils {
	
	/** The date format. */
	private static SimpleDateFormat dateFormat = new SimpleDateFormat(
            "MM/dd/yyyy");
	
	/**
	 * Format.
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String format(Date date) {
	    return dateFormat.format(date);
	}
	
	/**
	 * Checks if is same day.
	 *
	 * @param date1 the date 1
	 * @param date2 the date 2
	 * @return true, if is same day
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		return format(date1).equals(format(date2));
	}
	
}
