package org.arpita.airlinereservationsystem.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/*
 * Entity class for User
 */
@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;

	@Column(nullable = false)
	@NotEmpty(message = "firstName must not be empty")
	// @Size(min = 2, max = 50, message = "User name should be between 2 and 50
	// characters")
	private String firstName;

	@Column(nullable = false)
	@NotEmpty(message = "lastName must not be empty")
	@Size(min = 2, max = 50, message = "User name should be between 2 and 50 characters")
	private String lastName;

	@Column(unique = true)
	@NotEmpty(message = "username must not be empty")
	@Size(min = 2, max = 50, message = "User name should be between 2 and 50 characters")
	private String username;

	@Column(nullable = false)
	@NotEmpty(message = "email must not be empty")
	@Email
	private String email;

	@Column(nullable = false)
	@NotEmpty(message = "password must not be empty")
	private String password;

	public User() {

	}

	public User(String firstName, String lastName, String email, String username, String password) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, password, uId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& uId == other.uId;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}

}
