package org.arpita.airlinereservationsystem;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({FlightIT.class, PassengerIT.class })
@IncludeClassNamePatterns({"^.*IT?$", "^.*Test?$", "^.*Tests?$"})
//@IncludeClassNamePatterns({"^.*IT?$"})
public class SuiteTest {

}
