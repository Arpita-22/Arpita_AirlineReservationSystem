package org.arpita.airlinereservationsystem.services;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Flight;

public interface FlightService {

	Flight findFlightById(int id);
	
	Flight save(Flight flight);

	Iterable<Flight> getAllFlights();

	Iterable<Flight> findBySourceAndDestinationAndArrivalDateAndDepartureDate(String source, String destination,
			String arrivalDate, String departureDate)throws ReservationException;

	Iterable<Flight> findBySourceAndDestination(String source, String destination) throws ReservationException;
	
	void removeFlight(Flight flight);
	
	

}
