package org.arpita.airlinereservationsystem.controllers;


import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice
public class HomeController {
	
	private UserService userService;
	
	public HomeController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping("/passengerList")
	public String showPassengerListPage() {
		return "passengerList";
	}
	
 	
	@GetMapping("/")
	public String showHomePage(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(!principal.equals("anonymousUser"))
		{
			UserDetails userDetails = (UserDetails)principal;
			User user = userService.findByUsername(userDetails.getUsername());
			System.out.println("User: "+user);
			if(user!=null) {
				model.addAttribute("currentUser", user);
				
			}
		}
		return "index";
	}
	


}
