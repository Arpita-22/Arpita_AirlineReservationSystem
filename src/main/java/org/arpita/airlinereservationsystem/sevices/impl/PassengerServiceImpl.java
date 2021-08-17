package org.arpita.airlinereservationsystem.sevices.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.arpita.airlinereservationsystem.models.Passenger;
import org.arpita.airlinereservationsystem.repositories.PassengerRepository;
import org.arpita.airlinereservationsystem.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

	private PassengerRepository passengerRepository;

	@Autowired
	public PassengerServiceImpl(PassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}

	@Override
	public Passenger createPassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

	@Override
	public Passenger findPassengerById(int id) {
		Optional<Passenger> optPass = passengerRepository.findById(id);
		if(optPass.isPresent()) {
			return optPass.get();
		}
		
		throw new EntityNotFoundException();
	}

	@Override
	public List<Passenger> getAllPassengers(){
		return passengerRepository.findAll();
	}

	@Override
	public void removePassengerById(int id) {
		passengerRepository.deleteById(id);
	}

	@Override
	public Passenger save(Passenger passenger) {
		return passengerRepository.save(passenger);
	}

}
