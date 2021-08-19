package org.arpita.airlinereservationsystem;

import java.util.ArrayList;
import java.util.List;

import org.arpita.airlinereservationsystem.config.WebAppConfig;
import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.models.PassengerList;
import org.arpita.airlinereservationsystem.services.BookingService;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.services.PassengerService;
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
	
	@Autowired
	public BookingIT(FlightService flightService, BookingService bookingService,PassengerService passengerService) {
		this.flightService = flightService;	
		this.bookingService = bookingService;
		this.passengerService = passengerService;
	}
	
	@Test
	void testFindBookingById() {
//		Flight flight = flightService.findFlightById(9);
//		Booking newBooking = new Booking(flight);
//		
//		
//		List <Passenger> passengers = new ArrayList<>();
//		
//		for(Passenger passenger : flight.getPassengers()) {
//			passengers.add(passenger);
//			
//		}
//		
//		
//		newBooking.setPassengers(passengers);
//		Booking savedBooking = bookingService.save(newBooking);
//		Booking foundBooking = bookingService.findBookingById(savedBooking.getbId());
//		
//		System.out.println(savedBooking);
//		System.out.println(foundBooking);
//		Assertions.assertEquals(savedBooking,foundBooking);
//		
//		Booking foundBooking = bookingService.findBookingById(1);
//		System.out.println(foundBooking);
//		
//		Assertions.assertNotNull(foundBooking);
		
		
		
	}

}
