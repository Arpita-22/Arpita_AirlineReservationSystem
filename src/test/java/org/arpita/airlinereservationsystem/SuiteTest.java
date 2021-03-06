package org.arpita.airlinereservationsystem;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * Test suite for all unit tests classes
 * 
 * @author arpita
 *
 */
@RunWith(JUnitPlatform.class)
@SelectClasses({ FlightIT.class, PassengerIT.class, UserIT.class, BookingIT.class, TicketIT.class })
//@IncludeClassNamePatterns({"^.*IT?$", "^.*Test?$", "^.*Tests?$"})
@IncludeClassNamePatterns({ "^.*IT?$", "^.*Test?$" })
public class SuiteTest {

}
