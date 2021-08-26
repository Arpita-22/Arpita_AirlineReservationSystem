package org.arpita.airlinereservationsystem.services;

import java.util.List;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.models.Ticket;

public interface TicketService {
	
	Ticket save (Ticket ticket);
	
	Ticket findById(int tId);
	
	void removeTicket(Ticket ticket);
	
//	List<Ticket> findByUser_username(String username) throws ReservationException;

}
