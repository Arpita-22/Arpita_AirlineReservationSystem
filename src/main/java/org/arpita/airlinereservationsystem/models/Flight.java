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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Entity class for Flight
 */
@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fId;

	private String source;
	private String destination;

	private String departureDate;

	private String arrivalDate;

	private String departureTime;

	private String arrivalTime;

	private float price;

	private int flightNumber;

	private String departureCityName;

	private String arrivalCityName;

	@OneToMany(targetEntity = Passenger.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Passenger> passengers;

	public Flight() {
		this.passengers = new ArrayList<>();

	}

	public Flight(String source, String destination, String departureTime, String arrivalTime, int flightNumber,
			String departureDate, String arrivalDate, float price, String departureCityName, String arrivalCityName) {
		this();
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.flightNumber = flightNumber;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.price = price;
		this.arrivalCityName = arrivalCityName;
		this.departureCityName = departureCityName;

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

	/**
	 * @return the departureDate
	 */
	public String getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the arrivalDate
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the departureCityName
	 */
	public String getDepartureCityName() {
		return departureCityName;
	}

	/**
	 * @param departureCityName the departureCityName to set
	 */
	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
	}

	/**
	 * @return the arrivalCityName
	 */
	public String getArrivalCityName() {
		return arrivalCityName;
	}

	/**
	 * @param arrivalCityName the arrivalCityName to set
	 */
	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivalCityName, arrivalDate, arrivalTime, departureCityName, departureDate, departureTime,
				destination, fId, flightNumber, passengers, price, source);
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
		return Objects.equals(arrivalCityName, other.arrivalCityName) && Objects.equals(arrivalDate, other.arrivalDate)
				&& Objects.equals(arrivalTime, other.arrivalTime)
				&& Objects.equals(departureCityName, other.departureCityName)
				&& Objects.equals(departureDate, other.departureDate)
				&& Objects.equals(departureTime, other.departureTime) && Objects.equals(destination, other.destination)
				&& fId == other.fId && flightNumber == other.flightNumber
				&& Objects.equals(passengers, other.passengers)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(source, other.source);
	}

	@Override
	public String toString() {
		return "Flight [fId=" + fId + ", source=" + source + ", destination=" + destination + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", price=" + price + ", flightNumber=" + flightNumber + ", departureCityName="
				+ departureCityName + ", arrivalCityName=" + arrivalCityName + ", passengers=" + passengers + "]";
	}

}
