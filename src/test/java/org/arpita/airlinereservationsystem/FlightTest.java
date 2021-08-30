package org.arpita.airlinereservationsystem;

import static org.mockito.Matchers.anyInt;

import java.util.Optional;

import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.repositories.FlightRepository;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.sevices.impl.FlightServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Flight tests using Mockito
 * 
 * @author arpita
 *
 */
class FlightTest {

	private static FlightService flightService;
	private static FlightRepository flightRepository;

	@BeforeAll
	static void setup() {
		flightRepository = Mockito.mock(FlightRepository.class);
		flightService = new FlightServiceImpl(flightRepository);
	}

	@Test
	void testFindFlightById() {
		Optional<Flight> expected = Optional.ofNullable(new Flight("ATL", "LAX", "5:00 am", "8:00 am", 123,
				"2021-08-22", "2021-08-23", 50, "Atlanta", "Los Angeles"));
		Mockito.when(flightRepository.findById(anyInt())).thenReturn(expected);
		Optional<Flight> actual = Optional.ofNullable(flightService.findFlightById(1));
		Assertions.assertEquals(expected.toString(), actual.toString());
	}

}
