package org.arpita.airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.arpita.airlinereservationsystem.config.WebAppConfig;
import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.services.PassengerService;
import org.junit.jupiter.api.AfterAll;
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
class PassengerIT {

	private PassengerService passengerService;

	private Passenger expected;

	@Autowired
	public PassengerIT(PassengerService passengerService) {
		this.passengerService = passengerService;
	}

	@BeforeAll
	void setup() {

		Passenger passenger = new Passenger();

		passenger.setFirstName("firstName");
		passenger.setLastName("lastName");
		passenger.setEmail("email@email.com");
		passenger.setDateOfBirth(LocalDate.now());
		passenger.setGender("gender");
		passenger.setPersonalId("personalId");

		expected = passengerService.createPassenger(passenger);

	}

	@Test
	void testFindPassengerById() {
		Passenger actual = passengerService.findPassengerById(expected.getpId());
		assertEquals(expected, actual);

	}

	@AfterAll
	void clearSetup() {
		passengerService.removePassenger(expected);
	}

}
