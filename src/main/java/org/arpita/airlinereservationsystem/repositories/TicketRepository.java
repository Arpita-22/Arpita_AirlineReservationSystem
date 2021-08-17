package org.arpita.airlinereservationsystem.repositories;

import org.arpita.airlinereservationsystem.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
