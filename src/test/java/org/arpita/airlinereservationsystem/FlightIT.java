package org.arpita.airlinereservationsystem;


import org.arpita.airlinereservationsystem.config.WebAppConfig;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.junit.jupiter.api.Assertions;
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

	@Autowired
	public FlightIT(FlightService flightService) {
		this.flightService = flightService;
	}

//	@Test
//	void testFindPassenger() {
//		Flight foundPassenger = flightService.findAllPassengers(1);
//		System.out.println(foundPassenger.toString());
//	}

	@Test
	void testFindFlightById() {
		Flight foundFlight = flightService.findFlightById(1);
		System.out.println(foundFlight);
		Assertions.assertNotNull(foundFlight);
	}


	@Test
	void testGetAllFlights() {
		Iterable<Flight> flightList = flightService.getAllFlights();
		for(Flight flight: flightList) {
			System.out.println(flight);
			
		}
		Assertions.assertNotNull(flightList);
		
	}
	
	@Test
	void testFindBySourceAndDestinationAndArrivalTimeAndDepartureTime() {
		Iterable<Flight> flightSelected = flightService.findBySourceAndDestinationAndArrivalTimeAndDepartureTime("Denver", "Boston", "08/26/2021", "08/26/2021");
		for(Flight flight: flightSelected) {
			System.out.println(flight);
			
		}
		Assertions.assertNotNull(flightSelected);
		
	}
	
	
	@Test
	void testFindBySourceAndDestination() {
		Iterable<Flight> flightSelected = flightService.findBySourceAndDestination("Denver", "California");
		for(Flight flight: flightSelected) {
			System.out.println(flight);
			
		}
		Assertions.assertNotNull(flightSelected);
		
	}
	
//	@Test
//	void testRemovePassenger() {
//		Iterable<Passenger> passengers = flightService.findFlightById(1).getPassengers();
//		Flight removedPassenger = null;
//		for(Passenger passenger: passengers) {
//			System.out.println(passenger);
//			if(passenger.getpId() == 33) {
//				removedPassenger = flightService.removePassenger(passenger);
//			}
//		}
//		Assertions.assertFalse(flightService.findFlightById(1).getPassengers().contains(removedPassenger));
//	}

}
