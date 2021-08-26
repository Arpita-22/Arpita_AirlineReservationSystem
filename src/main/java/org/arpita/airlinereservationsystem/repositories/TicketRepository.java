package org.arpita.airlinereservationsystem.repositories;

import java.util.List;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
//	 List<Ticket> findByUser_username(String username) throws ReservationException;

}
