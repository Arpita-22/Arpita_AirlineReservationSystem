package org.arpita.airlinereservationsystem.repositories;

import org.arpita.airlinereservationsystem.models.User;
import org.springframework.data.repository.CrudRepository;

/*
 * User repository interface 
 */
public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * Find by email
	 * @param email
	 * @return
	 */
	User findByEmail(String email);

	/**
	 * Find by user name
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

}
