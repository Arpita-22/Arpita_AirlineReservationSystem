package org.arpita.airlinereservationsystem.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Selenium config for tests
 * 
 * @author arpita
 *
 */
@Configuration
public class SeleniumConfig {

	@Bean
	public WebDriver getWebDriver(Environment env) {
		System.setProperty("webdriver.chrome.driver", "/Users/arpita/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		return driver;

	}

}
