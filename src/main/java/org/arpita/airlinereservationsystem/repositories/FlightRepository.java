package org.arpita.airlinereservationsystem.repositories;

import java.util.List;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*
 * Flight repository interface 
 */
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	/**
	 * Find by departure city name and arrival city name and departure date custom query
	 * @param departureCityName
	 * @param arrivalCityName
	 * @param departureDate
	 * @return
	 * @throws ReservationException
	 */
	Iterable<Flight> findByDepartureCityNameAndArrivalCityNameAndDepartureDate(String departureCityName,
			String arrivalCityName, String departureDate) throws ReservationException;

	/**
	 * Find departure city name custom query  
	 * @param source
	 * @return
	 */
	@Query("select f.departureCityName from Flight f where lower(f.departureCityName) like %:source%")
	List<String> findSource(@Param("source") String source);

	/**
	 * Find arrival city name custom query
	 * @param destination
	 * @return
	 * @throws ReservationException
	 */
	@Query("select f.arrivalCityName from Flight f where lower(f.arrivalCityName) like %:destination%")
	List<String> findDestination(@Param("destination") String destination) throws ReservationException;

}
