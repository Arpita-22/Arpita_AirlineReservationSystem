package org.arpita.airlinereservationsystem.repositories;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	Iterable<Flight> findBySourceAndDestinationAndArrivalDateAndDepartureDate(String source, String destination,
			String arrivalDate, String departureDate)throws ReservationException;

	Iterable<Flight> findBySourceAndDestination(String source, String destination) throws ReservationException;
	


}
