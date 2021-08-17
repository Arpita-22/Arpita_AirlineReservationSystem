package org.arpita.airlinereservationsystem.services;

import org.arpita.airlinereservationsystem.models.Ticket;

public interface TicketService {
	
	Ticket save (Ticket ticket);
	
	Ticket findById(int tId);

}
