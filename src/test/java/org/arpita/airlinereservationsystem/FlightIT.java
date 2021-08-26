package org.arpita.airlinereservationsystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.arpita.airlinereservationsystem.config.WebAppConfig;
import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class FlightIT {

	private FlightService flightService;
	
	private Flight expected;
	
	private List<Flight>flights;
	
	

	@Autowired
	public FlightIT(FlightService flightService) {
		this.flightService = flightService;
		this.flights = new ArrayList<>();
		
	}
	
	@BeforeAll
	void setup() {

		 expected = new Flight("Georgia", "New York", "5:00 am", "8:00 am", 123, 
				"2021-08-22", "2021-08-23", 50);
		 
		 Flight flight2 = new Flight("Georgia", "New York", "8:00 am", "11:00 am", 321, 
					"2021-08-22", "2021-08-23", 50);

		
		flight2 = flightService.save(flight2);
		expected = flightService.save(expected);
		
		flights.add(expected);
		flights.add(flight2);
	}
	
	
	
	@Test
	void testFindFlightById() {
		Flight actual = flightService.findFlightById(expected.getfId());
		System.out.println(actual);
		Assertions.assertEquals(expected.toString(), actual.toString());
	}


	@Test
	void testGetAllFlights() {
		Iterable<Flight> flightIterable = flightService.getAllFlights();
		List<Flight> flightList = new ArrayList<>();
		
		for(Flight flight: flightIterable) {
			flightList.add(flight);
		}
		
		Assertions.assertEquals(expected.toString(), flightList.get(flightList.size() - 1).toString());

		//if no data inside the tables then this test would pass
//		Assertions.assertEquals(flights.size(),flightList.size());
		
	}
	
	
	
	@Test
	void testFindBySourceAndDestination() {
		Iterable<Flight> flightSelected;
		try {
			flightSelected = flightService.findBySourceAndDestination("Georgia", "New York");
			List<Flight> flightList = new ArrayList<>();
			
			for(Flight flight: flightSelected) {
				flightList.add(flight);
			}
//			Assertions.assertEquals(expected.toString(), flights.get(0).toString());
			Assertions.assertEquals(flights.size(),flightList.size());
		} catch (ReservationException e) {
			e.getMessage();
		}
		
		
	}
	
	@Test
	void testfindBySourceAndDestinationAndArrivalDateAndDepartureDate() {
		Iterable<Flight> flightSelected;
		try {
			flightSelected = flightService.findBySourceAndDestinationAndArrivalDateAndDepartureDate("Georgia", "New York", "2021-08-23","2021-08-22");
			List<Flight> flightList = new ArrayList<>();
			
			for(Flight flight: flightSelected) {
				flightList.add(flight);
			}
//			Assertions.assertEquals(expected.toString(), flights.get(0).toString());
			Assertions.assertEquals(flights.size(),flightList.size());
		} catch (ReservationException e) {
			e.getMessage();
		}
		
		
	}
	
	
	@AfterAll
	void clearSetup() {
		for(Flight flight: flights) {
			flightService.removeFlight(flight);
			
		}
	}
	

}
