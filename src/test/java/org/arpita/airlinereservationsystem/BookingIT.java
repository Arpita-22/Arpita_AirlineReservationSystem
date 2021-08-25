package org.arpita.airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.arpita.airlinereservationsystem.config.WebAppConfig;
import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.services.BookingService;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.services.PassengerService;
import org.arpita.airlinereservationsystem.services.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookingIT {

	private FlightService flightService;
	private BookingService bookingService;
	private PassengerService passengerService;
	private UserService userService;
	
	private Booking expected;
	private User user;

	@Autowired
	public BookingIT(FlightService flightService, BookingService bookingService, PassengerService passengerService,
			UserService userService) {
		this.flightService = flightService;
		this.bookingService = bookingService;
		this.passengerService = passengerService;
		this.userService = userService;
	}
	
	
	@BeforeAll
	void setup() {
		Flight flight = flightService.findFlightById(9);

		User u = new User();
		u.setFirstName("John");
		u.setLastName("Doe");
		u.setUsername("John");
		u.setEmail("john@email.com");
		u.setPassword("john1234");
		user = userService.createUser(u);
		
		
		List<Passenger> passengers = new ArrayList<>();
		Passenger passenger = new Passenger();
		
		passenger.setFirstName("firstName");
		passenger.setLastName("lastName");
		passenger.setEmail("email@email.com");
		passenger.setDateOfBirth(LocalDate.now());
		passenger.setGender("gender");
		passenger.setPersonalId("personalId");
		
		passengers.add(passengerService.save(passenger));

		Booking newBooking = new Booking(flight, user, passengers);
		 expected = bookingService.save(newBooking);

	}
	
	@AfterAll
	void clearSetup() {
		
		bookingService.removeBooking(expected);
		userService.removeUser(user);
	}
	
	@Test
	void testFindUserById() {
		
		Booking actual = bookingService.findBookingById(expected.getbId());
		assertEquals(expected.toString(), actual.toString());
	}
	
	
	
	@ParameterizedTest
	@ValueSource(strings = "John")
	void testFindByUser_username(String username) {
		
		List<Booking> actual = bookingService.findByUser_username(username);	
		assertEquals(expected.toString(),actual.get(0).toString());
				
		
	}
	

}
