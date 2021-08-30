package org.arpita.airlinereservationsystem.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Controller class for Flight
 */
@Controller
public class FlightController {

	private static final Logger LOG = LoggerFactory.getLogger(FlightController.class);

	private FlightService flightService;

	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	/**
	 * Method to return list of city names for Ajax call for departure city
	 * 
	 * @param source
	 * @return
	 * @throws ReservationException
	 */
	@GetMapping(value = "/searchBySource", headers = "Accept=*/*", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody Set<String> searchBySource(@RequestParam("search") String source) throws ReservationException {
		List<String> airportCodes = flightService.findSource(source.toLowerCase());
		System.out.println(airportCodes);
		return new HashSet<>(airportCodes);
	}

	/**
	 * Method to return list of city names for Ajax call for arrival city
	 * 
	 * @param destination
	 * @return
	 * @throws ReservationException
	 */
	@GetMapping(value = "/searchByDestination", headers = "Accept=*/*", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody Set<String> searchByDestination(@RequestParam("search") String destination)
			throws ReservationException {
		List<String> airportCodes = flightService.findDestination(destination.toLowerCase());
		System.out.println(airportCodes);
		return new HashSet<>(airportCodes);
	}

	/**
	 * Method to search flights by arrival city, departure city and departure date
	 * 
	 * @param model
	 * @param stateFrom
	 * @param stateTo
	 * @param depart
	 * @return
	 */
	@PostMapping("/search")
	public String showSearchPage(Model model, @RequestParam("stateFrom") String stateFrom,
			@RequestParam("stateTo") String stateTo, @RequestParam("depart") String depart) {
		try {
			model.addAttribute("selectedFlights", flightService
					.findByDepartureCityNameAndArrivalCityNameAndDepartureDate(stateFrom, stateTo, depart));
			return "search";
		} catch (ReservationException e) {
			LOG.error(e.getMessage());
			return "error_page";
		}
	}

	/**
	 * Method to search flights by Id
	 * 
	 * @param fid
	 * @param session
	 * @return
	 */
	@GetMapping("/flights/{flightId}")
	public String bookFlightById(@PathVariable("flightId") int fid, HttpSession session) {

		session.setAttribute("flightId", fid);

		return "redirect:/passenger_info";
	}

	/**
	 * Method to return all flights available
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/allFlights")
	public String showAllFlights(Model model) {

		List<Flight> flights = new ArrayList<>();
		Iterable<Flight> iter = flightService.getAllFlights();
		int limit = 200;
		for (Flight flight : iter) {
			flights.add(flight);
			if (limit == 0) {
				break;
			}
			limit--;
		}

		model.addAttribute("flights", flights);

		return "all_flights";
	}

}
