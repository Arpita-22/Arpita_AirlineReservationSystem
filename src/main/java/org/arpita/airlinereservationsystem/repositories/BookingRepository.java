package org.arpita.airlinereservationsystem.repositories;

import java.util.List;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Booking repository interface 
 */
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	/**
	 * Find by user name custom query
	 * @param username
	 * @return
	 * @throws ReservationException
	 */
	List<Booking> findByUser_username(String username) throws ReservationException;

}
