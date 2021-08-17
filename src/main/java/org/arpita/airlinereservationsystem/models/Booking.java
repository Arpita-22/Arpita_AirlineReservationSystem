package org.arpita.airlinereservationsystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bId;
	
	@OneToMany(targetEntity = Passenger.class)
	private List <Passenger> passengers;
	
	@OneToOne(targetEntity = Flight.class)
	private Flight flight;
	
	
	
	public Booking(){
		this.passengers = new ArrayList<>();
		
	}

	public Booking(Flight flight) {
		this();
		this.flight = flight;
		
			
		}
	
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}

	/**
	 * @return the passengers
	 */
	public List<Passenger> getPassengers() {
		return passengers;
	}

	/**
	 * @param passengers the passengers to set
	 */
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
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
		return Objects.hash(bId, flight, passengers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return bId == other.bId && Objects.equals(flight, other.flight) && Objects.equals(passengers, other.passengers);
	}

	@Override
	public String toString() {
		return "Booking [bId=" + bId + ", passengers=" + passengers + ", flight=" + flight + "]";
	}


	
}
