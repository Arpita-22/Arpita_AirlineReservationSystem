package org.arpita.airlinereservationsystem.services;

import java.util.List;

import org.arpita.airlinereservationsystem.models.Passenger;

public interface PassengerService {

	Passenger createPassenger(Passenger passenger);

	Passenger findPassengerById(int id);

	List<Passenger> getAllPassengers();

	void removePassengerById(int id);

	Passenger save(Passenger passenger);
	
	void removePassenger(Passenger passenger);

//	Passenger findByEmail(String email);

}
