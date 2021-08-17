package org.arpita.airlinereservationsystem.sevices.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
		if(optTicket.isPresent()) {
			return optTicket.get();
		}
		throw new EntityNotFoundException();
	}
	
	

}
