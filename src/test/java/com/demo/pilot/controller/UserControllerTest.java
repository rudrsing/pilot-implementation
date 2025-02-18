
package com.demo.pilot.controller;

import com.demo.pilot.model.User;
import com.demo.pilot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	/*
	 * This method is used to test the getUser method of the UserController class.		
	 * 
     * @throws Exception
	 */
	@Test
	public void testGetUser() throws Exception {
		User user = new User();
		user.setId("1");
		user.setName("John Doe");

		when(userService.getUser("1")).thenReturn(user);

		mockMvc.perform(get("/users/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value("1"))
				.andExpect(jsonPath("$.name").value("John Doe"));
	}

	/*
	 * This method is used to test the addUser method of the UserController class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddUser() throws Exception {
		User user = new User();
		user.setId("1");
		user.setName("John Doe");

		mockMvc.perform(post("/users").contentType("application/json").content("{\"id\":\"1\",\"name\":\"John Doe\"}"))
				.andExpect(status().isCreated());

		verify(userService, times(1)).addUser(any(User.class));
	}

}
