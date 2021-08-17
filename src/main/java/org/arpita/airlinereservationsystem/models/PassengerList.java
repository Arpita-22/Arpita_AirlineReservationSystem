package org.arpita.airlinereservationsystem.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PassengerList {

	private List<Passenger> passengerList = new ArrayList<>();

	public PassengerList() {
		super();
	}

	public PassengerList(List<Passenger> passengerList) {
		super();
		this.passengerList = passengerList;
	}

	/**
	 * @param passengerList the passengerList to set
	 */
	public void addPassenger(Passenger passenger) {
		this.passengerList.add(passenger);
	}

	/**
	 * @return the passengerList
	 */
	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	/**
	 * @param passengerList the passengerList to set
	 */
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(passengerList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerList other = (PassengerList) obj;
		return Objects.equals(passengerList, other.passengerList);
	}

	@Override
	public String toString() {
		return "PassengerList [passengerList=" + passengerList + "]";
	}

}
