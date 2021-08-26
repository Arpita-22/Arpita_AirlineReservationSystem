package org.arpita.airlinereservationsystem.sevices.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.models.Ticket;
import org.arpita.airlinereservationsystem.repositories.TicketRepository;
import org.arpita.airlinereservationsystem.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	@Autowired
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;

	}

	@Override
	public Ticket save(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket findById(int tId) {
		Optional<Ticket> optTicket = ticketRepository.findById(tId);
		if (optTicket.isPresent()) {
			return optTicket.get();
		}
		throw new EntityNotFoundException();
	}

	@Override
	public void removeTicket(Ticket ticket) {
		ticketRepository.delete(ticket);
		
	}

//	@Override
//	public List<Ticket> findByUser_username(String username) throws ReservationException {
//		return ticketRepository.findByUser_username(username);
//	}
//	
	
	
	

}
