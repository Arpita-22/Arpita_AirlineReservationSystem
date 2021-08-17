package org.arpita.airlinereservationsystem.sevices.impl;

import java.util.Optional;

import org.arpita.airlinereservationsystem.models.Flight;
import org.arpita.airlinereservationsystem.repositories.FlightRepository;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

	private FlightRepository flightRepository;

	@Autowired
	public FlightServiceImpl(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

//	@Override
//	public Flight findAllPassengers(int fId) {
//		return flightRepository.findAllPassengers(fId);
//	}

	@Override
	public Flight findFlightById(int id) {
		Optional<Flight> optFlight = flightRepository.findById(id);
		if (optFlight.isPresent()) {
			return optFlight.get();
		}
		return null;
	}

	@Override
	public Flight save(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public Iterable<Flight> getAllFlights() {
		Iterable<Flight> optFlight = flightRepository.findAll();
		return (Iterable<Flight>) optFlight;
	}

	@Override
	public Iterable<Flight> findBySourceAndDestinationAndArrivalTimeAndDepartureTime(String source, String destination,
			String arrivalTime, String departureTime) {
		Iterable<Flight> optFlight = flightRepository.findBySourceAndDestinationAndArrivalTimeAndDepartureTime(source,
				destination, arrivalTime, departureTime);
		return optFlight;
	}

	@Override
	public Iterable<Flight> findBySourceAndDestination(String source, String destination) {
		Iterable<Flight> optFlight = flightRepository.findBySourceAndDestination(source, destination);
		return optFlight;
	}


	

}
