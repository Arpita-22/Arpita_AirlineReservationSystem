package org.arpita.airlinereservationsystem.services;

import org.arpita.airlinereservationsystem.models.Flight;

public interface FlightService {

//	Flight findAllPassengers(int id);
	Flight findFlightById(int id);

	Flight save(Flight flight);

	Iterable<Flight> getAllFlights();

	Iterable<Flight> findBySourceAndDestinationAndArrivalTimeAndDepartureTime(String source, String destination,
			String arrivalTime, String departureTime);

	Iterable<Flight> findBySourceAndDestination(String source, String destination);
	
	 
	
}
