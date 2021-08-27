package org.arpita.airlinereservationsystem.controllers;

import javax.validation.Valid;

import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	private UserService userService;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}


	@GetMapping("/signUp")
	public String showSignUpPage(Model model) {
		model.addAttribute("user", new User());
		return "sign_up";
	}
	


	@SuppressWarnings("finally")
	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult errors, Errors error,
			Model model) {
		System.out.println("Errors? " + errors.hasErrors());
		if (errors.hasErrors()) {
			return "sign_up";
		}

		try {
			if (userService.findByUsername(user.getUsername()) != null) {
				errors.rejectValue("username", "errors.user", "The user is already in use");
				return "sign_up";
			}
		} catch (Exception e) {
			LOG.error("Error while sign Up", e);
			return "error_page";
		} finally {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userService.createUser(user);
			return "login";

		}
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("firstName", "lastName", "email", "password", "username");

	}

	
	@GetMapping("/login")
	public String showLoginPage(Model model) {
		return "login";
	}

}
