package org.arpita.airlinereservationsystem.controllers;

import javax.servlet.http.HttpSession;

import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.models.Ticket;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.services.PassengerService;
import org.arpita.airlinereservationsystem.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TicketController {
	private FlightService flightService;
	private PassengerService passengerService;
	private TicketService ticketService;
	
	
	@Autowired
	public TicketController(FlightService flightService, PassengerService passengerService,TicketService ticketService) {
		this.flightService = flightService;
		this.passengerService = passengerService;
		this.ticketService = ticketService;
	}
	
	
	@GetMapping("/ticket/{passengerId}")
	public String showTicketPage(@PathVariable("passengerId") int passengerId, HttpSession session, Model model) {
		
		System.out.println(passengerId);
		
		int flightId = (int) session.getAttribute("flightId");
		Flight flight = flightService.findFlightById(flightId);
		
		Passenger passenger = passengerService.findPassengerById(passengerId);

		Ticket ticket = new Ticket(1234 + passengerId, (double)(Math.floor((Math.random() * (200 - 30 + 1))+30)*100/100d),
				passenger, flight);
		ticketService.save(ticket);
		
		model.addAttribute("ticket", ticket);
//		session.invalidate();
		
		return "ticketPage";
	}
	
	@GetMapping("/passenger/ticket/{passengerId}")
	public String showUpdatedTicketPage(@PathVariable("passengerId") int passengerId, HttpSession session, Model model) {
		
		System.out.println(passengerId);
		
		int flightId = (int) session.getAttribute("flightId");
		Flight flight = flightService.findFlightById(flightId);
		
		Passenger passenger = passengerService.findPassengerById(passengerId);

		Ticket ticket = new Ticket(1234 + passengerId, (double)(Math.floor((Math.random() * (200 - 30 + 1))+30)*100/100d),
				passenger, flight);
		ticketService.save(ticket);
		
		model.addAttribute("ticket", ticket);
//		session.invalidate();
		
		return "ticketPage";
	}

}
