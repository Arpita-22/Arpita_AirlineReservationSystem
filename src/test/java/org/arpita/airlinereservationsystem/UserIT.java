package org.arpita.airlinereservationsystem;


import org.arpita.airlinereservationsystem.config.WebAppConfig;
import org.arpita.airlinereservationsystem.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class UserIT {
	
private UserService userService;

	
	@Autowired
	public UserIT( UserService userService) {
		this.userService = userService;
	}
	
	
	@Test
	void testFindById() {
//		Passenger newPassenger = new Passenger();
//		newPassenger.setEmail("apple@email.com");
//	    newPassenger.setPassword("apple111");
//		Passenger savedPassenger = passengerService.save(newPassenger);
//		Passenger foundPassenger = passengerService.findPassengerById(savedPassenger.getpId());
//		System.out.println(foundPassenger.getpId());
//		assertEquals(savedPassenger, foundPassenger);

	}
	
	@Test
	void testFindByEmail() {
//		User newUser = new User("Cory", "Reed", "cr@email.com","cory11");
//		User savedUser = userService.save(newUser);
//		User foundUser = userService.findByEmail(savedUser.getEmail());
//		assertEquals(savedUser, foundUser);
		
//		Passenger foundPassenger = passengerService.findByEmail("cr@email.com");
//		System.out.println(foundPassenger.toString());
//		
//		Assertions.assertNotNull(foundPassenger);
//		
	}
	
	

}
