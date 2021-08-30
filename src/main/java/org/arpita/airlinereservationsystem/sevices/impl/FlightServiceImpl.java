package org.arpita.airlinereservationsystem.sevices.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.repositories.FlightRepository;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Flight Service implementation class 
 */
@Service
public class FlightServiceImpl implements FlightService {

	private FlightRepository flightRepository;

	@Autowired
	public FlightServiceImpl(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	@Override
	public Flight save(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public Flight findFlightById(int id) {
		Optional<Flight> optFlight = flightRepository.findById(id);
		if (optFlight.isPresent()) {
			return optFlight.get();
		}
		throw new EntityNotFoundException();
	}

	@Override
	public Iterable<Flight> getAllFlights() {
		Iterable<Flight> optFlight = flightRepository.findAll();
		return (Iterable<Flight>) optFlight;
	}

	@Override

	public Iterable<Flight> findByDepartureCityNameAndArrivalCityNameAndDepartureDate(String departureCityName,
			String arrivalCityName, String departureDate) throws ReservationException {
		return flightRepository.findByDepartureCityNameAndArrivalCityNameAndDepartureDate(departureCityName,
				arrivalCityName, departureDate);
	}

	@Override
	public Iterable<Flight> findBySourceAndDestination(String source, String destination) throws ReservationException {
		return flightRepository.findBySourceAndDestination(source, destination);
	}

	@Override
	public void removeFlight(Flight flight) {
		flightRepository.delete(flight);

	}

	@Override
	public List<String> findSource(String source) throws ReservationException {
		return flightRepository.findSource(source);

	}

	@Override
	public List<String> findDestination(String destination) throws ReservationException {
		return flightRepository.findDestination(destination);
	}

}
