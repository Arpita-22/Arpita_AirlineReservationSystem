package org.arpita.airlinereservationsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.arpita.airlinereservationsystem.config.WebAppConfig;
import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.models.Ticket;
import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.services.BookingService;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.services.PassengerService;
import org.arpita.airlinereservationsystem.services.TicketService;
import org.arpita.airlinereservationsystem.services.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
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
class TicketIT {

	private TicketService ticketService;
	private BookingService bookingService;
	private PassengerService passengerService;
	private FlightService flightService;
	private UserService userService;

	private User user;
	private Flight flight;
	private Booking booking;

	private Ticket expected;

	private List<Passenger> passengers;
	
//	private List<Ticket> tickets;

	@Autowired
	public TicketIT(TicketService ticketService, BookingService bookingService, PassengerService passengerService,
			FlightService flightService, UserService userService) {
		this.passengers = new ArrayList<>();
		this.ticketService = ticketService;
		this.bookingService = bookingService;
		this.flightService = flightService;
		this.passengerService = passengerService;
		this.userService = userService;
	}

	@BeforeAll
	void setup() {

		

		User u = new User();
		u.setFirstName("John");
		u.setLastName("Doe");
		u.setUsername("John");
		u.setEmail("john@email.com");
		u.setPassword("john1234");
		user = userService.createUser(u);

		Passenger passenger = new Passenger();

		passenger.setFirstName("firstName");
		passenger.setLastName("lastName");
		passenger.setEmail("email@email.com");
		passenger.setDateOfBirth(LocalDate.now());
		passenger.setGender("gender");
		passenger.setPersonalId("personalId");

		passengers.add(passenger);
		
		Flight f = new Flight();
		f.setFlightNumber(123);
		f.setSource("Georgia");
		f.setDestination("New York");
		f.setDepartureDate("2021-08-22");
		f.setArrivalDate("2021-08-23");
		f.setDepartureTime("5:00 am");
		f.setArrivalTime("8:00 am");
		f.setPrice(50);
		f.setPassengers(passengers);
		flight = flightService.save(f);

		Booking newBooking = new Booking(flight, user, passengers);
		booking = bookingService.save(newBooking);

		Ticket ticket = new Ticket();
		ticket.setPnrNumber(1234);
		ticket.setPrice(50.0);
		ticket.setBooking(booking);

		expected = ticketService.save(ticket);
//		tickets.add(expected);

	}



	@Test
	void testFindById() {
		Ticket actual = ticketService.findById(expected.gettId());
		Assertions.assertEquals(expected.toString(), actual.toString());
	}
	
	
//	@ParameterizedTest
//	@ValueSource(strings = {"John"})
//	void testFindByUser_username(String username) {
//		
//		try {
//			List<Booking> actual;
//			actual = bookingService.findByUser_username(username);
////			assertEquals(expected.toString(),actual.get(0).toString());
////			assertEquals(tickets.size(), actual.size());
//			assertEquals(expected.toString(), actual.get(actual.size() - 1).toString());
//		} catch (ReservationException e) {
//			e.getMessage();
//		}	
//				
//		
//	}
	
	@AfterAll
	void clearSetup() {	
		
		ticketService.removeTicket(expected);
		bookingService.removeBooking(booking);
		userService.removeUser(user);		
		flightService.removeFlight(flight);

	}

}
