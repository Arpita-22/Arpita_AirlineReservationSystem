package org.arpita.airlinereservationsystem.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * Entity class for Ticket
 */
@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;

	@OneToOne(targetEntity = Booking.class)
	private Booking booking;

	private int pnrNumber;
	private double price;

	public Ticket() {

	}

	public Ticket(int pnrNumber, double price, Booking booking) {
		this();
		this.pnrNumber = pnrNumber;
		this.price = price;
		this.booking = booking;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public int hashCode() {
		return Objects.hash(booking, pnrNumber, price, tId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Objects.equals(booking, other.booking) && pnrNumber == other.pnrNumber
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && tId == other.tId;
	}

	@Override
	public String toString() {
		return "Ticket [tId=" + tId + ", booking=" + booking + ", pnrNumber=" + pnrNumber + ", price=" + price + "]";
	}

}
