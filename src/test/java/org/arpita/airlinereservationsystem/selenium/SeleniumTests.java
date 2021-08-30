package org.arpita.airlinereservationsystem.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.arpita.airlinereservationsystem.config.WebAppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

/**
 * Selenium test for the application Run main application and then run the
 * Selenium test on Junit
 * 
 * @author arpita
 *
 */

class SeleniumTests {

	private WebDriver driver;

	@Autowired
	public SeleniumTests(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	void testLoginPage() {
		// Opens the login page for this web application
		driver.get("http://localhost:8080/AirlineReservationSystem");
		assertEquals("Login", driver.getTitle());
	}

}
