package org.arpita.airlinereservationsystem;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.arpita.airlinereservationsystem.config.WebAppConfig;
import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.services.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
private User expected;


	
	@Autowired
	public UserIT( UserService userService) {
		this.userService = userService;
	}
	
	@BeforeAll
	void setup() {

		User u = new User();
		u.setFirstName("John");
		u.setLastName("Doe");
		u.setUsername("John");
		u.setEmail("john@email.com");
		u.setPassword("john1234");
		expected = userService.createUser(u);
	}
	
	
	
	@Test
	void testFindUserById() {
		User actual = userService.findUserById(expected.getuId());
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"John"})
	void testFindByUsername(String username) {
		User actual = userService.findByUsername(username);
		assertEquals(expected, actual);
		}
	
	
	@AfterAll
	void clearSetup() {
		userService.removeUser(expected);
	}
}
