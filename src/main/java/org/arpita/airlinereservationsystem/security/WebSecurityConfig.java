//package org.arpita.airlinereservationsystem.security;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.arpita.airlinereservationsystem.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//@ComponentScan("org.arpita.airlinereservationsystem")
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
//	
//	private UserService userService;
//
//	@Autowired
//	public WebSecurityConfig(UserService userService) {
//		this.userService = userService;
//
//	}
//	
//	
//	@SuppressWarnings("deprecation")
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder()
//				.username("testUser1")
//				.password("testPass1")
//				.roles("USER")
//				.build());
//		users.add(User.withDefaultPasswordEncoder()
//				.username("testUser2")
//				.password("testPass2")
//				.roles("USER")
//				.build());
//		return new InMemoryUserDetailsManager(users);
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// CSRF is disabled for simplification and demonstration.
//		// Do not use this configuration for production.
//		http.csrf().disable()
//		// Allows all requests access to the /login URL
//		.authorizeRequests().antMatchers("/**").permitAll()
//		// Specifies that we would like to use a custom form to login
//		.and().formLogin().loginPage("/").permitAll()
//		// Specifies that any authenticated user can access all URLs
//		.and().authorizeRequests().anyRequest().authenticated()
//		.and()
//		// Upon logout, invalidate the session and clear authentication
//		.logout().invalidateHttpSession(true).clearAuthentication(true)
//		// Specifies Logout URL
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		// Forward to /logoutsuccess upon logout and allow all requests
//		.logoutSuccessUrl("/logout").permitAll();
////		super.configure(http);
//	}
//
//}
