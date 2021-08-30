package org.arpita.airlinereservationsystem.repositories;

import org.arpita.airlinereservationsystem.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Passenger repository interface 
 */
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
