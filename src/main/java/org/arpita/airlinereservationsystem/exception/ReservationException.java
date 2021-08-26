package org.arpita.airlinereservationsystem.exception;

public class ReservationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ReservationException(String message) {
		super(message);
	}

	public ReservationException(String message, Exception exception) {
		super(message, exception);
	}

	@Override
	public String getMessage() {
		return "Internal error occured!!";
	}

}
