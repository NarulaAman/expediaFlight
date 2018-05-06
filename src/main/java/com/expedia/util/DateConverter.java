package com.expedia.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.expedia.exception.BadRequestException;

/**
 * The Class DateConverter.
 */
public final class DateConverter implements Converter<String, Date> {
 
	/** The format. */
	SimpleDateFormat format = null;
	
    /**
     * Instantiates a new date converter.
     */
    public DateConverter() {
    	format = new SimpleDateFormat("dd/MM/yyyy");
    }
 
    @Override
    public Date convert(String source) {
		if(source == null) {
			return null;
		}	
		try {
			return format.parse(source);
		} catch (ParseException e) {
			throw new BadRequestException("Date format not supported , supported Date format : dd/MM/yyyy");
		}      
    }
}