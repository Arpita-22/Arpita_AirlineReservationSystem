package org.arpita.airlinereservationsystem.services;

import org.arpita.airlinereservationsystem.models.Booking;

public interface BookingService {
	
	Booking save (Booking booking);
	Booking findBookingById(int bId);

}
