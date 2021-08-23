package org.arpita.airlinereservationsystem.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.models.PassengerList;
import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.services.BookingService;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.services.PassengerService;
import org.arpita.airlinereservationsystem.services.TicketService;
import org.arpita.airlinereservationsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PassengerController {

	private FlightService flightService;
	private PassengerService passengerService;
	private TicketService ticketService;
	private BookingService bookingService;
	private UserService userService;

	@Autowired
	public PassengerController(FlightService flightService, PassengerService passengerService,
			TicketService ticketService, BookingService bookingService, UserService userService) {
		this.flightService = flightService;
		this.passengerService = passengerService;
		this.ticketService = ticketService;
		this.bookingService = bookingService;
		this.userService = userService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@GetMapping("/passengerInfo")
	public String showPassengerPage(Model model) {
		model.addAttribute("passenger", new Passenger());
		PassengerList passengerList = new PassengerList();
		passengerList.addPassenger(new Passenger());
		model.addAttribute("passengerList", passengerList);
		System.out.println(model);

		return "passengerInfo";
	}

	@PostMapping("/createPassenger")
	public String createPassenger(@Valid @ModelAttribute("passengerList") PassengerList passengerList,
			BindingResult errors, HttpSession session, Model model) {

		System.out.println("Errors? " + errors.hasErrors());

		if (errors.hasErrors()) {
			return "search";
		}
		
		for (Passenger passenger : passengerList.getPassengerList()) {
			passengerService.save(passenger);
		}
		

//		int flightId = (int) session.getAttribute("flightId");
//		Flight flight = flightService.findFlightById(flightId);
//		List<Passenger> passengers = new ArrayList<>();
//		
//
//		if (flight.getPassengers() != null) {
//			passengers.addAll(flight.getPassengers());
//
//		}
//
//		for (Passenger passenger : passengerList.getPassengerList()) {
//			passengers.add(passenger);
//		}
//
//		flight.setPassengers(passengers);
//		flightService.save(flight);
		
//		User user = (User) session.getAttribute("currentUser");
//		Booking booking = new Booking(flight, user, passengerList.getPassengerList());
//		bookingService.save(booking);

		session.setAttribute("currentPassengersInSession", passengerList);
		model.addAttribute("passengers", passengerList.getPassengerList());
		//model.addAttribute("passengers", booking.getPassengers());
		
		return "passengerList";
	}

	@GetMapping("/passenger/remove/{passengerId}")
	public String removePassengerById(@PathVariable("passengerId") int pid, HttpSession session, Model model) {

//		int flightId = (int) session.getAttribute("flightId");
//		Flight flight = flightService.findFlightById(flightId);
		Passenger passen = passengerService.findPassengerById(pid);

//		flight.getPassengers().remove(passen);
//		flightService.save(flight);

//		Booking booking = (Booking) session.getAttribute("booking");
//
		PassengerList oldPassengers = (PassengerList) session.getAttribute("currentPassengersInSession");
		List<Passenger> updatedPaxList = new ArrayList<>();
		for (Passenger pax: oldPassengers.getPassengerList()) {
			if(pax.getpId() != pid) {
				updatedPaxList.add(pax);
			}
		}

//		booking.setPassengers(passengersUpdated);
//		bookingService.save(booking);

		passengerService.removePassengerById(pid);
		session.setAttribute("currentPassengersInSession", new PassengerList(updatedPaxList));
		model.addAttribute("passengers", updatedPaxList);

		return "passengerList";
//		return "redirect:/";
	}

	@GetMapping("/passenger/{passengerId}")
	public String updatePassengerById(@PathVariable("passengerId") int passengerId, HttpSession session, Model model) {
//		int flightId = (int) session.getAttribute("flightId");
//		Flight flight = flightService.findFlightById(flightId);
//
//		Booking booking = (Booking) session.getAttribute("booking");
//
//		for (Passenger passenger : booking.getPassengers()) {
//
//			if (passenger.getpId() == passengerId) {
//
//				model.addAttribute("passenger", passenger);
//				session.setAttribute("passengerId", passengerId);
//				break;
//			}
//		}
		
		model.addAttribute("passenger", passengerService.findPassengerById(passengerId));
		session.setAttribute("passengerId", passengerId);
		return "updatePassengerInfo";
	}

	@PostMapping("/passenger/updatePassenger")
	public String updatePassenger(@Valid @ModelAttribute("passenger") Passenger passenger, Model model,
			BindingResult errors, HttpSession session) {

		System.out.println("Errors? " + errors.hasErrors());

		if (errors.hasErrors()) {
			return "updatePassenger";
		}
		int pid = (int) session.getAttribute("passengerId");
		passenger.setpId(pid);
		passengerService.save(passenger);
		
		PassengerList oldPassengers = (PassengerList) session.getAttribute("currentPassengersInSession");
		List<Passenger> updatedPaxList = new ArrayList<>();
		for (Passenger pax: oldPassengers.getPassengerList()) {
			if(pax.getpId() != passenger.getpId()) {
				updatedPaxList.add(pax);
			}
		}
		updatedPaxList.add(passenger);
		
		session.setAttribute("currentPassengersInSession", new PassengerList(updatedPaxList));
		model.addAttribute("passengers", updatedPaxList);
		
//		int flightId = (int) session.getAttribute("flightId");
//		Flight flight = flightService.findFlightById(flightId);
//		Booking booking = (Booking) session.getAttribute("booking");
//
//		List<Passenger> passengersUpdated = new ArrayList<>();
//		List<Passenger> passengersUpdated2 = new ArrayList<>();
//
//		for (Passenger p : flight.getPassengers()) {
//			if (p.getpId() == (int) session.getAttribute("passengerId")) {
//
//				p.setFirstName(passenger.getFirstName());
//				p.setLastName(passenger.getLastName());
//				p.setEmail(passenger.getEmail());
//				p.setDateOfBirth(passenger.getDateOfBirth());
//				p.setGender(passenger.getGender());
//				p.setPersonalId(passenger.getPersonalId());
//
//			}
//			passengersUpdated.add(p);
//		}
//
//		flight.setPassengers(passengersUpdated);
//		flightService.save(flight);
//
//		for (Passenger p : booking.getPassengers()) {
//			if (p.getpId() == (int) session.getAttribute("passengerId")) {
//
//				p.setFirstName(passenger.getFirstName());
//				p.setLastName(passenger.getLastName());
//				p.setEmail(passenger.getEmail());
//				p.setDateOfBirth(passenger.getDateOfBirth());
//				p.setGender(passenger.getGender());
//				p.setPersonalId(passenger.getPersonalId());
//
//			}
//			passengersUpdated2.add(p);
//		}
//
//		booking.setPassengers(passengersUpdated2);
//		bookingService.save(booking);
//
////		model.addAttribute("passengers", flight.getPassengers());
//
//		model.addAttribute("passengers", booking.getPassengers());

		return "passengerList";

	}

}
