package org.arpita.airlinereservationsystem.controllers;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice
public class HomeController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	private UserService userService;

	public HomeController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/passengerList")
	public String showPassengerListPage() {
		return "passenger_list";
	}

	@GetMapping("/")
	public String showHomePage(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (!principal.equals("anonymousUser")) {
			UserDetails userDetails = (UserDetails) principal;
			User user;

				user = userService.findByUsername(userDetails.getUsername());
				System.out.println("User: " + user);
				if (user != null) {
					model.addAttribute("currentUser", user);
				}
		}
		return "index";
	}

}
