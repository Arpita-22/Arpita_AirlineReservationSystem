package org.arpita.airlinereservationsystem;

import org.arpita.airlinereservationsystem.config.WebAppConfig;
import org.arpita.airlinereservationsystem.models.Ticket;
import org.arpita.airlinereservationsystem.services.FlightService;
import org.arpita.airlinereservationsystem.services.PassengerService;
import org.arpita.airlinereservationsystem.services.TicketService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WebAppConfig.class })
@WebAppConfiguration("webapp")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TicketIT {
	
	private TicketService ticketService;
	private PassengerService passengerService;
	private FlightService flightService;

	@Autowired
	public TicketIT (TicketService ticketService,PassengerService passengerService,FlightService flightService) {
		this.ticketService = ticketService;
		this.passengerService = passengerService;
		this.flightService = flightService;
	}
	
	
//	@Test
//	void testFindById() {
//		Ticket newTicket = new Ticket(1235, 201.0, passengerService.findPassengerById(4), flightService.findFlightById(1));
//		Ticket savedTicket = ticketService.save(newTicket);
//		Ticket foundTicket = ticketService.findById(savedTicket.gettId());
//		Assertions.assertEquals(savedTicket, foundTicket);
//	}
		
	
}
