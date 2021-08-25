package org.arpita.airlinereservationsystem.services;

import java.util.List;

import org.arpita.airlinereservationsystem.models.User;

public interface UserService {

	User createUser(User user);

	User findUserById(int id);

	List<User> getAllUsers();

	void removeUserById(int id);

	User save(User user);

	User findByEmail(String email);
	
	User findByUsername(String username);
	
	void removeUser(User user);


}
