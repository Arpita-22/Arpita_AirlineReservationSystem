package org.arpita.airlinereservationsystem.repositories;

import org.arpita.airlinereservationsystem.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	Iterable<Flight> findBySourceAndDestinationAndArrivalTimeAndDepartureTime(String source, String destination,
			String arrivalTime, String departureTime);

	Iterable<Flight> findBySourceAndDestination(String source, String destination);
	



}
