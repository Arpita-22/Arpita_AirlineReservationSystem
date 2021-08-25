package org.arpita.airlinereservationsystem.controllers;

import javax.servlet.http.HttpSession;

import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.models.Ticket;
import org.arpita.airlinereservationsystem.services.BookingService;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TicketController {
	private FlightService flightService;
	private TicketService ticketService;
	private BookingService bookingService;
	
	
	@Autowired
	public TicketController(FlightService flightService, TicketService ticketService, BookingService bookingService) {
		this.flightService = flightService;
		this.ticketService = ticketService;
		this.bookingService = bookingService;
	}
	
	
	@GetMapping("/ticket/{bookingId}")
	public String showTicketPage(@PathVariable("bookingId") int bookingId, HttpSession session, Model model) {
	
		
		int flightId = (int) session.getAttribute("flightId");
		Flight flight = flightService.findFlightById(flightId);
		

		
		Booking booking = bookingService.findBookingById(bookingId);

//		Ticket ticket = new Ticket(1234 + passengerId, (double)(Math.floor((Math.random() * (200 - 30 + 1))+30)*100/100d),
//				passenger, flight);
		
		Ticket ticket = new Ticket((1234 + bookingId), flight.getPrice() + 50, booking);
		ticketService.save(ticket);
		model.addAttribute("ticket", ticket);
		
		return "ticketPage";
	}
	


}
