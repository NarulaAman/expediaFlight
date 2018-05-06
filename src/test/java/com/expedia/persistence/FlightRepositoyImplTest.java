package com.expedia.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.expedia.AppConfig;
import com.expedia.domain.Flight;

/**
 * The Class FlightRepositoyImplTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@PrepareForTest(FlightDatabase.class)
public class FlightRepositoyImplTest {

	/** The flight repo. */
	@Autowired
	@Qualifier("flightRepo")
	FlightRepository flightRepo;
	
	private static Map<String,Flight> flights = new HashMap<>();
	
    @Rule
    public PowerMockRule rule = new PowerMockRule(); 

	@Before
	public void setUp() {

		/*Flight Data*/
		
		Calendar cal = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.set(cal.get(Calendar.YEAR), 
				cal.get(Calendar.MONTH), 
				cal.get(Calendar.DATE), 
				23, 35);

		Flight flight1 = new  Flight();
		flight1.setName("AC A1001");
		flight1.setDepartureCity("Montreal");
		flight1.setOperator("AIR CANADA");
		flight1.setDepartureTime(calendar.getTime());
		flights.put(flight1.getName(), flight1);
		
		/*Rules*/
		
		PowerMockito.mockStatic(FlightDatabase.class);
		PowerMockito.when(FlightDatabase.getFlights()).thenReturn(flights);
		
		
	}

	/**
	 * Test flight by time.
	 */
	@Test
	public void testFlightByTime() {
		assertTrue(flightRepo.flightByTime("4:30").size() == 1);	
	}
	
	/**
	 * Test flight by name.
	 */
	@Test
	public void testFlightByName() {
		assertNotNull(flightRepo.flightByName("AC A1001"));
	}
	
	/**
	 * Test flights.
	 */
	@Test
	public void testFlights() {
		assertTrue(flightRepo.flights().size() == 1);
	}
}
