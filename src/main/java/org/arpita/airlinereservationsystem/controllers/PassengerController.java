package org.arpita.airlinereservationsystem.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.models.PassengerList;
import org.arpita.airlinereservationsystem.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * Controller class for Passenger
 */
@Controller
public class PassengerController {

	private PassengerService passengerService;

	@Autowired
	public PassengerController(PassengerService passengerService) {
		this.passengerService = passengerService;
	}

	/**
	 * Method to show passenger information
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/passenger_info")
	public String showPassengerPage(Model model) {

		model.addAttribute("passenger", new Passenger());
		PassengerList passengerList = new PassengerList();
		passengerList.addPassenger(new Passenger());
		model.addAttribute("passengerList", passengerList);

		return "passenger_info";
	}

	/**
	 * Method to create passenger information
	 * 
	 * @param passengerList
	 * @param errors
	 * @param session
	 * @param model
	 * @return
	 */
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

		session.setAttribute("currentPassengersInSession", passengerList);
		model.addAttribute("passengers", passengerList.getPassengerList());

		return "passenger_list";
	}

	/**
	 * Method to remove passenger by Id
	 * 
	 * @param pid
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/passenger/remove/{passengerId}")
	public String removePassengerById(@PathVariable("passengerId") int pid, HttpSession session, Model model) {

		PassengerList oldPassengers = (PassengerList) session.getAttribute("currentPassengersInSession");
		List<Passenger> updatedPaxList = new ArrayList<>();
		for (Passenger pax : oldPassengers.getPassengerList()) {
			if (pax.getpId() != pid) {
				updatedPaxList.add(pax);
			}
		}

		passengerService.removePassengerById(pid);

		session.setAttribute("currentPassengersInSession", new PassengerList(updatedPaxList));
		model.addAttribute("passengers", updatedPaxList);

		return "passenger_list";

	}

	/**
	 * Method to get passenger by Id
	 * 
	 * @param passengerId
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/passenger/{passengerId}")
	public String updatePassengerById(@PathVariable("passengerId") int passengerId, HttpSession session, Model model) {

		model.addAttribute("passenger", passengerService.findPassengerById(passengerId));
		session.setAttribute("passengerId", passengerId);
		return "update_passenger_info";
	}

	/**
	 * Method to update passenger
	 * 
	 * @param passenger
	 * @param model
	 * @param errors
	 * @param session
	 * @return
	 */
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
		for (Passenger pax : oldPassengers.getPassengerList()) {
			if (pax.getpId() != passenger.getpId()) {
				updatedPaxList.add(pax);
			}
		}
		updatedPaxList.add(passenger);

		session.setAttribute("currentPassengersInSession", new PassengerList(updatedPaxList));
		model.addAttribute("passengers", updatedPaxList);

		return "passenger_list";

	}

}
