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

//
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

// Run main application and then run the Selenium test on Junit
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
//	
////	@Test
////	void testLogin() throws InterruptedException {
////		driver.get("http://localhost:8080/");
////		WebElement usernameInput = driver.findElement(By.cssSelector("body > form > div:nth-child(1) > input[type=text]"));
////		usernameInput.sendKeys("John");
////		WebElement passwordInput = driver.findElement(By.cssSelector("body > form > div:nth-child(2) > input[type=text]"));
////		passwordInput.sendKeys("john1234");
////		Thread.sleep(3000);
////		driver.findElement(By.cssSelector("body > form > div:nth-child(3) > input[type=submit]")).click();	
////		
////		WebElement welcomeMessage = driver.findElement(By.cssSelector("body > h2"));
////    	Thread.sleep(3000);
////		assertEquals("Home Page",driver.getTitle());
////		assertTrue(welcomeMessage.getText().contains("John"));
////		
////	}
}
