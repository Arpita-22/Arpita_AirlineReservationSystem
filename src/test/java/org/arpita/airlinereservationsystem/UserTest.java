package org.arpita.airlinereservationsystem;

import org.arpita.airlinereservationsystem.repositories.FlightRepository;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.sevices.impl.FlightServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;

public class UserTest {
	
	private static FlightService flightService;
	private static FlightRepository flightRepository;
	
	@BeforeAll
	static void setup() {
		flightRepository = Mockito.mock(FlightRepository.class);
		flightService = new FlightServiceImpl(flightRepository);
	}

}
