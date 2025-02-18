package com.demo.pilot.service;

import com.demo.pilot.model.User;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	private final Map<String, User> userMap = new HashMap<>();

	public User getUser(String id) {
		logger.info("Fetching user with ID: {}", id);
		User user = userMap.get(id);
		if (user != null) {
			logger.info("User found: {}", user);
		} else {
			logger.warn("User with ID: {} not found", id);
		}
		return user;
	}

	public void addUser(User user) {
		logger.info("Adding user: {}", user);
		userMap.put(user.getId(), user);
		logger.info("User added successfully");
	}
}
