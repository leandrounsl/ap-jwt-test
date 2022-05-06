package com.argentina.programa.jwt.test.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.argentina.programa.jwt.test.dto.UserDTO;
import com.argentina.programa.jwt.test.exception.UserAlreadyExistAuthenticationException;
import com.argentina.programa.jwt.test.model.User;
import com.argentina.programa.jwt.test.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = (User) userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public User save(UserDTO userDTO) {
		
		User userDB = (User) userRepository.findByUsername(userDTO.getUsername());
		if (userDB != null) 
			throw new UserAlreadyExistAuthenticationException(userDTO.getUsername());
		
		User newUser = new User();
		newUser.setUsername(userDTO.getUsername());
		newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		return userRepository.save(newUser);
	}
}