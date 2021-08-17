package org.arpita.airlinereservationsystem.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.models.PassengerList;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.services.PassengerService;
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

	@Autowired
	public PassengerController(FlightService flightService, PassengerService passengerService) {
		this.flightService = flightService;
		this.passengerService = passengerService;
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

		int flightId = (int) session.getAttribute("flightId");
		Flight flight = flightService.findFlightById(flightId);
		List<Passenger> passengers = new ArrayList<>();
		for (Passenger passenger : passengerList.getPassengerList()) {
			passengers.add(passenger);
		}
		flight.setPassengers(passengers);
		flightService.save(flight);

		model.addAttribute("passengers", flightService.findFlightById(flightId).getPassengers());
		return "passengerList";
	}

	@GetMapping("/passengers/{passengerId}")
	public String removePassengerById(@PathVariable("passengerId") int pid, HttpSession session) {
		int flightId = (int) session.getAttribute("flightId");
		Flight flight = flightService.findFlightById(flightId);
		Passenger passen = passengerService.findPassengerById(pid);
		flight.getPassengers().remove(passen);
		flightService.save(flight);
		passengerService.removePassengerById(pid);
		return "redirect:/";
	}

	@GetMapping("/passenger/{passengerId}")
	public String updatePassengerById(@PathVariable("passengerId") int passengerId, HttpSession session, Model model) {
		int flightId = (int) session.getAttribute("flightId");
		Flight flight = flightService.findFlightById(flightId);

		for (Passenger passenger : flight.getPassengers()) {

			if (passenger.getpId() == passengerId) {

				model.addAttribute("passenger", passenger);
				session.setAttribute("passengerId", passengerId);
				break;
			}
		}
//		model.addAttribute("ticket", new Ticket());
		return "updatePassengerInfo";
	}

	@PostMapping("/passenger/updatePassenger")
	public String updatePassenger(@Valid @ModelAttribute("passenger") Passenger passenger, Model model,
			BindingResult errors, HttpSession session) {

		System.out.println("Errors? " + errors.hasErrors());

		if (errors.hasErrors()) {
			return "updatePassenger";
		}

		int flightId = (int) session.getAttribute("flightId");
		Flight flight = flightService.findFlightById(flightId);

//		Ticket ticket = new Ticket();

		List<Passenger> passengersUpdated = new ArrayList<>();
		for (Passenger p : flight.getPassengers()) {
			if (p.getpId() == (int) session.getAttribute("passengerId")) {

				p.setFirstName(passenger.getFirstName());
				p.setLastName(passenger.getLastName());
				p.setEmail(passenger.getEmail());
				p.setDateOfBirth(passenger.getDateOfBirth());
				p.setGender(passenger.getGender());
				p.setPersonalId(passenger.getPersonalId());

			}
			passengersUpdated.add(p);
		}

		flight.setPassengers(passengersUpdated);
		flightService.save(flight);

		System.out.println(flight);

		return "redirect:/";
	}

}
