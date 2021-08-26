package org.arpita.airlinereservationsystem.sevices.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.arpita.airlinereservationsystem.exception.ReservationException;
import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.repositories.UserRepository;
import org.arpita.airlinereservationsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findUserById(int id) {
		Optional<User> optuser = userRepository.findById(id);
		if (optuser.isPresent()) {
			return optuser.get();
		}
		throw new EntityNotFoundException();
	}

	@Override
	public List<User> getAllUsers() {
		Iterable<User> optPassenger = userRepository.findAll();
		return (List<User>) optPassenger;
	}

	@Override
	public void removeUserById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void removeUser(User user) {
		userRepository.delete(user);

	}

}
