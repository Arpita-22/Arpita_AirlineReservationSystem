package org.arpita.airlinereservationsystem.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.models.PassengerList;
import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.services.BookingService;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.services.PassengerService;
import org.arpita.airlinereservationsystem.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookingController {

	private static final Logger LOG = LoggerFactory.getLogger(BookingController.class);

	private BookingService bookingService;
	private FlightService flightService;
	private UserService userService;
	private PassengerService passengerService;

	@Autowired
	public BookingController(BookingService bookingService, FlightService flightService, UserService userService, 
			PassengerService passengerService) {
		this.bookingService = bookingService;
		this.flightService = flightService;
		this.userService = userService;
		this.passengerService = passengerService;
	}

	@GetMapping("/booking")
	public String showBookingPage(HttpSession session, Model model) {

		try {

			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetails userDetails = (UserDetails) principal;
			User user = userService.findByUsername(userDetails.getUsername());

			int flightId = (int) session.getAttribute("flightId");
			Flight flight = flightService.findFlightById(flightId);

			PassengerList passengerList = (PassengerList) session.getAttribute("currentPassengersInSession");
			List<Passenger> passengers = passengerList.getPassengerList();

			if (flight.getPassengers() == null) {
				flight.setPassengers(passengers);
			} else {
				flight.getPassengers().addAll(passengers);

			}
			flightService.save(flight);

			Booking booking = new Booking(flight, user, passengers);
			bookingService.save(booking);
			model.addAttribute("booking", booking);
			return "confirm_booking_page";

		} catch (EntityNotFoundException e) {
			LOG.error("Entity not found error while booking", e);
			return "error_page";
		} catch (Exception e) {
			LOG.error("Error while booking", e);
			return "error_page";
		}
	}
	
	

	@GetMapping("/viewUserBooking")
	public String showAllUserBooking(HttpSession session, Model model) {

		try {
			
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetails userDetails = (UserDetails) principal;
			User user = userService.findByUsername(userDetails.getUsername());
			
			model.addAttribute("bookings", bookingService.findByUser_username(user.getUsername()));

		} catch (ReservationException e) {
			e.printStackTrace();
		}
		return "user_booking";
	}
	
	
	
	
	@GetMapping("/removeBooking/{bookingId}")
	public String removeBooking(@PathVariable("bookingId") int bId, HttpSession session) {
		
		Booking booking = bookingService.findBookingById(bId);
		List<Passenger> passengers = new ArrayList<>();
		
		List<Integer> passengerIds = new ArrayList<>();
		
		int flightId = (int) session.getAttribute("flightId");
		Flight flight = flightService.findFlightById(flightId);
		
		for(Passenger p : flight.getPassengers()) {
		for(Passenger passenger: booking.getPassengers()) {
				if(p.getpId() != passenger.getpId()) {
					passengers.add(p);
				}
				else {
					passengerIds.add(passenger.getpId());
				}
				
			}
			
			
		}
		
		flight.setPassengers(passengers);
		flightService.save(flight);
		
		bookingService.removeBooking(booking);
		
		for(Integer id : passengerIds) {
			passengerService.removePassengerById(id);
		}
			
				
		return "deleted_booking";
		
	}
	
	

}
