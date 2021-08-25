package org.arpita.airlinereservationsystem.repositories;

import org.arpita.airlinereservationsystem.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);
	
	User findByUsername(String username);



}
