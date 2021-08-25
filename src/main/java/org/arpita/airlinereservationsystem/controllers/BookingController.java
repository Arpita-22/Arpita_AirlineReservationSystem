package org.arpita.airlinereservationsystem.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.models.PassengerList;
import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.services.BookingService;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
	private BookingService bookingService;
	private FlightService flightService;
	private UserService userService;

	@Autowired
	public BookingController(BookingService bookingService, FlightService flightService,UserService userService) {
		this.bookingService = bookingService;
		this.flightService = flightService;
		this.userService = userService;
	}

	@GetMapping("/booking")
	public String showBookingPage(HttpSession session, Model model) {

//		User user = (User) session.getAttribute("currentUser");
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails)principal;
		User user = userService.findByUsername(userDetails.getUsername());
		
		int flightId = (int) session.getAttribute("flightId");
		Flight flight = flightService.findFlightById(flightId);

		PassengerList passengerList = (PassengerList) session.getAttribute("currentPassengersInSession");
		List<Passenger> passengers = passengerList.getPassengerList();
		
		if(flight.getPassengers() == null) {
			flight.setPassengers(passengers);
		}else {
			flight.getPassengers().addAll(passengers);
			
		}	
		flightService.save(flight);
		
		Booking booking = new Booking(flight, user, passengers);
		bookingService.save(booking);
		model.addAttribute("booking", booking);
		return "confirmBookingPage";
	}
	
	

}
