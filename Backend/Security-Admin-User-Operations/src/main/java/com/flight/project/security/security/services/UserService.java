package com.flight.project.security.security.services;


import com.flight.project.security.model.User;

public interface UserService {

	void updateUser(User user);
	User getUserById(String id);
}
