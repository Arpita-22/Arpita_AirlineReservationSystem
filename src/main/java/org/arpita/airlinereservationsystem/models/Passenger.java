package org.arpita.airlinereservationsystem.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "passengers")
public class Passenger {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;

	@NotEmpty(message = "firstName must not be empty")
	private String firstName;

	@NotEmpty(message = "lastName must not be empty")
	private String lastName;

//	@Column(unique = true)
	@NotEmpty(message = "email must not be empty")
	private String email;

//	@Column(nullable = false)
	@NotNull(message = "dateOfBirth must not be null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//	@JsonFormat(pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE)
	private Date dateOfBirth;

	@Column(nullable = false)
	@NotEmpty(message = "gender must not be empty")
	private String gender;

	private String personalId;
	
//	@ManyToOne(targetEntity = Booking.class)
//	private Booking booking;

	public Passenger() {

	}

	public Passenger(@NotEmpty(message = "firstName must not be empty") String firstName,
			@NotEmpty(message = "lastName must not be empty") String lastName,
			@NotEmpty(message = "email must not be empty") String email,
			@NotNull(message = "dateOfBirth must not be null") Date dateOfBirth,
			@NotEmpty(message = "gender must not be empty") String gender, String personalId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = new Date(dateOfBirth.getTime());
		this.gender = gender;
		this.personalId = personalId;
//		this.booking = booking;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = new Date(dateOfBirth.getTime());
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the personalId
	 */
	public String getPersonalId() {
		return personalId;
	}

	/**
	 * @param personalId the personalId to set
	 */
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
//
//	@Override
//	public int hashCode() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String dob = sdf.format(dateOfBirth);
//		return Objects.hash(dob, email, firstName, gender, lastName, pId, personalId);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Passenger other = (Passenger) obj;
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String dob = sdf.format(dateOfBirth);
//		String otherDob = sdf.format(other.dateOfBirth);
//		return Objects.equals(dob, otherDob)
//				&& Objects.equals(email, other.email)
//				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
//				&& Objects.equals(lastName, other.lastName) && pId == other.pId
//				&& Objects.equals(personalId, other.personalId);
//	}
//
//	@Override
//	public String toString() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String dob = sdf.format(dateOfBirth);
//		
//		return "Passenger [pId=" + pId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
//				+ ", dateOfBirth=" + dob + ", gender=" + gender + ", personalId=" + personalId + "]";
//	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, email, firstName, gender, lastName, pId, personalId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& Objects.equals(lastName, other.lastName) && pId == other.pId
				&& Objects.equals(personalId, other.personalId);
	}

	@Override
	public String toString() {
		return "Passenger [pId=" + pId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", personalId=" + personalId + "]";
	}




}
