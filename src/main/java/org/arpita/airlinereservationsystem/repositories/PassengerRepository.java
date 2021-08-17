package org.arpita.airlinereservationsystem.repositories;

import org.arpita.airlinereservationsystem.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
