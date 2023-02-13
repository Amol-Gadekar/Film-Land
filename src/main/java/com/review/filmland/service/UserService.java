package com.review.filmland.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.filmland.dao.UserRepository;
import com.review.filmland.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}

}
