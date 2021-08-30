package org.arpita.airlinereservationsystem.services;

import java.util.List;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Flight;

public interface FlightService {

	Flight findFlightById(int id);

	Flight save(Flight flight);

	Iterable<Flight> getAllFlights();

	Iterable<Flight> findByDepartureCityNameAndArrivalCityNameAndDepartureDate(String departureCityName,
			String arrivalCityName, String departureDate) throws ReservationException;

//	Iterable<Flight> findBySourceAndDestination(String source, String destination) throws ReservationException;

	void removeFlight(Flight flight);

	List<String> findSource(String source) throws ReservationException;

	List<String> findDestination(String destination) throws ReservationException;
}
