package org.arpita.airlinereservationsystem.controllers;

import javax.servlet.http.HttpSession;

import org.arpita.airlinereservationsystem.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightController {

	private FlightService flightService;
//	private BookingService bookingService;
//	private TestApi testApi;

	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
//		this.bookingService = bookingService;
	}

	@PostMapping("/search")
	public String showSearchPage(Model model, @RequestParam("stateFrom") String stateFrom,
			@RequestParam("stateTo") String stateTo, @RequestParam("depart") String depart,
			@RequestParam("returning") String returning) {
		System.out.println(depart);
		System.out.println(returning);
		model.addAttribute("selectedFlights", flightService.findBySourceAndDestination(stateFrom, stateTo));
		return "search";
	}

	@GetMapping("/flights/{flightId}")
	public String bookFlightById(@PathVariable("flightId") int fid, HttpSession session) {
		session.setAttribute("flightId", fid);
		return "redirect:/passengerInfo";
	}

//	@PostMapping("/createBooking")
//	public String createBooking(@Valid @ModelAttribute("Booking") Booking booking,
//			@PathVariable("flightId") int fid,
//			BindingResult errors) {
//		System.out.println("Errors? " + errors.hasErrors());
//		if(errors.hasErrors()) {
//			return "search";
//		}
//	    System.out.println(fid);
//	    
//    	Booking savedBooking = bookingService.createBooking(booking);
//		savedBooking.setFlightid(fid);
//		System.out.println(savedBooking.toString());
//		return "redirect:/passengerInfo";
//	}

}
