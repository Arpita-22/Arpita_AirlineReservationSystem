package org.arpita.airlinereservationsystem.repositories;

import org.arpita.airlinereservationsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	

}
