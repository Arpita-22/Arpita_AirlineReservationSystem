package org.arpita.airlinereservationsystem.repositories;

import org.arpita.airlinereservationsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

//	@Query("SELECT b FROM Booking b LEFT JOIN FETCH b.passengers")
//	List<Passenger> findAllPassengers();

}
