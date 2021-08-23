package org.arpita.airlinereservationsystem;

import java.util.ArrayList;
import java.util.Date;
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
class BookingIT {

	private FlightService flightService;
	private BookingService bookingService;
	private PassengerService passengerService;
	private UserService userService;

	@Autowired
	public BookingIT(FlightService flightService, BookingService bookingService, PassengerService passengerService,
			UserService userService) {
		this.flightService = flightService;
		this.bookingService = bookingService;
		this.passengerService = passengerService;
		this.userService = userService;
	}

	@Test
	void testFindBookingById() {
		Flight flight = flightService.findFlightById(9);
		User user = userService.findUserById(1);
		List<Passenger> passengers = new ArrayList<>();
		passengers.add(new Passenger("firstName", "lastName", "email", new Date(), "gender", "personalId"));

		Booking newBooking = new Booking(flight, user, passengers);
		Booking savedBooking = bookingService.save(newBooking);
		Booking foundBooking = bookingService.findBookingById(savedBooking.getbId());

		System.out.println(savedBooking);
		System.out.println(foundBooking);
//		Assertions.assertEquals(savedBooking.toString(), foundBooking.toString());
		Assertions.assertNotNull(foundBooking);
		
//		
//		Booking foundBooking = bookingService.findBookingById(1);
//		System.out.println(foundBooking);
//		
//		Assertions.assertNotNull(foundBooking);

	}
	
	

}
