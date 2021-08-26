package org.arpita.airlinereservationsystem.sevices.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.Booking;
import org.arpita.airlinereservationsystem.repositories.BookingRepository;
import org.arpita.airlinereservationsystem.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

	private BookingRepository bookingRepository;

	@Autowired
	public BookingServiceImpl(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;

	}

	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking findBookingById(int bId) {
		Optional<Booking> optBooking = bookingRepository.findById(bId);
		if (optBooking.isPresent()) {
			return optBooking.get();
		}
		throw new EntityNotFoundException();
	}

	@Override
	public void removeBooking(Booking booking) {
		bookingRepository.delete(booking);

	}

	@Override
	public List<Booking> findByUser_username(String username) throws ReservationException {
		return bookingRepository.findByUser_username(username);
	}

}
