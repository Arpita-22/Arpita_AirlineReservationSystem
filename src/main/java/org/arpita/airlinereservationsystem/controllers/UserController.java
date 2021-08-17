package org.arpita.airlinereservationsystem.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;

	}

	@GetMapping("/signUp")
	public String showSignUpPage(Model model) {
		model.addAttribute("user", new User());
		return "signUp";
	}

	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult errors) {
		System.out.println("Errors? " + errors.hasErrors());
		if (errors.hasErrors()) {
			return "signUp";
		}
		userService.createUser(user);
		return "redirect:/";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("firstName", "lastName", "email", "password");

	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

//    @GetMapping("/login")
//    public String login(Model model, String error, String logout) {
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//    }

	@PostMapping("/checkUser")
	public String checkPassenger(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session, ModelMap modelMap, Model model) {

		User existing = userService.findByEmail(email);

		if (existing != null) {
			if (password.equals(existing.getPassword()) && email.equals(existing.getEmail())) {
				System.out.println("Passwords matched.");
				session.setAttribute("currentUser", existing);
				return "redirect:/";
			}
		}
		model.addAttribute("error", "Invalid Account");
		modelMap.put("error", "Invalid Account");
		return "login";
	}

	@GetMapping("/welcome")
	public String showWelcomePage() {
		return "welcome";
	}

	@GetMapping("/logout")
	public String showLogoutPage(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
