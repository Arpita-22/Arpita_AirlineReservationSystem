package org.arpita.airlinereservationsystem.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "tickets")
public class Ticket {
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tId;
	
	@OneToOne(targetEntity = Passenger.class)
	private Passenger passenger;
	
	@OneToOne(targetEntity = Flight.class)
	private Flight flight;
	
	private int pnrNumber;
	private double price;
	
	
	public Ticket() {

	}
	

	public Ticket(int pnrNumber, double price, Passenger passenger, Flight flight) {
		this();
		this.pnrNumber = pnrNumber;
		this.price = price;
		this.passenger = passenger;
		this.flight = flight;
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
	 * @return the passenger
	 */
	public Passenger getPassenger() {
		return passenger;
	}


	/**
	 * @param passenger the passenger to set
	 */
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}


	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}


	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	@Override
	public int hashCode() {
		return Objects.hash(flight, passenger, pnrNumber, price, tId);
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
		return Objects.equals(flight, other.flight) && Objects.equals(passenger, other.passenger)
				&& pnrNumber == other.pnrNumber
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && tId == other.tId;
	}


	@Override
	public String toString() {
		return "Ticket [tId=" + tId + ", passenger=" + passenger + ", flight=" + flight + ", pnrNumber=" + pnrNumber
				+ ", price=" + price + "]";
	}


	
	

}
