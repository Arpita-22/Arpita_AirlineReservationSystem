package org.arpita.airlinereservationsystem.services;

import java.util.List;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Booking;

public interface BookingService {

	Booking save(Booking booking);

	Booking findBookingById(int bId);

	void removeBooking(Booking booking);
	
	List <Booking> findByUser_username(String username)throws ReservationException;

}
