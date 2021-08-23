package org.arpita.airlinereservationsystem.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice
public class HomeController {

	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}

	@GetMapping("/passengerList")
	public String showPassengerListPage() {
		return "passengerList";
	}

}
