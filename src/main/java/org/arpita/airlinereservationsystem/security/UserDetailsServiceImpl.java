package org.arpita.airlinereservationsystem.security;

import org.arpita.airlinereservationsystem.models.User;
import org.arpita.airlinereservationsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 * Spring security User details service  
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}
		return new CurrentUser(user);
	}

}
