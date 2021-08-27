package org.arpita.airlinereservationsystem.controllers;

import javax.servlet.http.HttpSession;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightController {

	private static final Logger LOG = LoggerFactory.getLogger(FlightController.class);

	private FlightService flightService;

	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}
	


	@PostMapping("/search")
	public String showSearchPage(Model model, @RequestParam("stateFrom") String stateFrom,
			@RequestParam("stateTo") String stateTo, @RequestParam("depart") String depart,
			@RequestParam("returning") String returning) {
		try {
			model.addAttribute("selectedFlights", flightService.findBySourceAndDestinationAndArrivalDateAndDepartureDate(stateFrom, stateTo, depart, returning));
			return "search";
		} catch (ReservationException e) {
			LOG.error(e.getMessage());
			return "error_page";
		}
	}
	

	
	@GetMapping("/flights/{flightId}")
	public String bookFlightById(@PathVariable("flightId") int fid, HttpSession session) {
		
		session.setAttribute("flightId", fid);
		
		return "redirect:/passenger_info";
	}
	
	
	
	@GetMapping("/allFlights")
	public String showAllFlights(Model model) {
		
		model.addAttribute("flights",flightService.getAllFlights());
		
		return "all_flights";
	}

}
