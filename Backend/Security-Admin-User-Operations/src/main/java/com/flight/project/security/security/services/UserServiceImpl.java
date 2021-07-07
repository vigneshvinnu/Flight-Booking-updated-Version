package com.flight.project.security.security.services;

import com.flight.project.security.model.User;
import com.flight.project.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@Override
	public void updateUser(User user) {
		this.userRepository.save(user);
		
	}

	@Override
	public User getUserById(String id) {
		return this.userRepository.findById(id).get();
	}

}
