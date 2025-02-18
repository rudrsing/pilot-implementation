
package com.demo.pilot.controller;

import com.demo.pilot.model.User;
import com.demo.pilot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * This method is used to get the user details based on the user id.
	 * 
	 * @param id - The user id.
	 * 
	 * @return User - The user details.	
	 */	
	@GetMapping("/{id}")
	public User getUser(@PathVariable String id) {
		return userService.getUser(id);
	}

	/*
     * This method is used to add a new user.
     * 
     * @param user - The user details.
     */
	 @PostMapping
	    public ResponseEntity<User> addUser(@RequestBody User user) {
	        userService.addUser(user);
	        return new ResponseEntity<>(user, HttpStatus.CREATED);
	    }
}
