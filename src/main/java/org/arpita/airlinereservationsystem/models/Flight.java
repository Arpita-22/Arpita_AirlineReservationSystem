package org.arpita.airlinereservationsystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@Column(name = "id")
	private int fId;

	private String source;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	private int flightNumber;
//	private float price;

	@OneToMany(targetEntity = Passenger.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Passenger> passengers;

	public Flight() {
		this.passengers = new ArrayList<>();

	}

	public Flight(String source, String destination, String departureTime, String arrivalTime, int flightNumber) {
		this();
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightNumber = flightNumber;

	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
//	 public void removePassenger(Passenger passenger) {
//	        this.passengers.remove(passenger);
//	    }

	@Override
	public int hashCode() {
		return Objects.hash(arrivalTime, departureTime, destination, fId, flightNumber, passengers, source);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(arrivalTime, other.arrivalTime) && Objects.equals(departureTime, other.departureTime)
				&& Objects.equals(destination, other.destination) && fId == other.fId
				&& flightNumber == other.flightNumber && Objects.equals(passengers, other.passengers)
				&& Objects.equals(source, other.source);
	}

	@Override
	public String toString() {
		return "Flight [fId=" + fId + ", source=" + source + ", destination=" + destination + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", flightNumber=" + flightNumber + ", passengers="
				+ passengers + "]";
	}

}
