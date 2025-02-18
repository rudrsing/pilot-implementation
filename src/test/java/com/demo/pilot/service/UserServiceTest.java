
package com.demo.pilot.service;

import com.demo.pilot.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

	private UserService userService;

	/*
	 * This method is used to set up the initial state of the test class.
	 */
	@BeforeEach
	void setUp() {
		userService = new UserService();
	}

	/*
	 * This method is used to test the getUser method of the UserService class.
	 */
	@Test
	void getUserReturnsUserWhenExists() {
		User user = new User();
		user.setId("1");
		user.setName("John Doe");
		userService.addUser(user);

		User result = userService.getUser("1");

		assertNotNull(result);
		assertEquals("John Doe", result.getName());
	}

	/*
	 * This method is used to test the getUser method of the UserService class.
	 */
	@Test
	void getUserReturnsNullWhenNotExists() {
		User result = userService.getUser("2");

		assertNull(result);
	}

	/*
	 * This method is used to test the addUser method of the UserService class.
	 */
	@Test
	void addUserStoresUser() {
		User user = new User();
		user.setId("3");
		user.setName("Jane Doe");

		userService.addUser(user);

		User result = userService.getUser("3");
		assertNotNull(result);
		assertEquals("Jane Doe", result.getName());
	}
	/*
     * This method is used to test the addUser method of the UserService class.
     */
	@Test
	void addUserOverwritesExistingUser() {
		User user1 = new User();
		user1.setId("4");
		user1.setName("John Smith");
		userService.addUser(user1);

		User user2 = new User();
		user2.setId("4");
		user2.setName("Jane Smith");
		userService.addUser(user2);

		User result = userService.getUser("4");
		assertNotNull(result);
		assertEquals("Jane Smith", result.getName());
	}
}
