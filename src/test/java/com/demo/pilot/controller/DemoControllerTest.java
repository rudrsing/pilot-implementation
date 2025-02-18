
package com.demo.pilot.controller;

import com.demo.pilot.model.Farmer;
import com.demo.pilot.service.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(DemoController.class)
class DemoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DemoService demoService;

	private Farmer farmer;

	@BeforeEach
	void setUp() {
		farmer = new Farmer();
		farmer.setId("1");
		farmer.setName("John Doe");
	}

	@Test
	void getFarmerReturnsFarmerWhenExists() throws Exception {
		when(demoService.getFarmer("1")).thenReturn(farmer);

		mockMvc.perform(get("/farmers/1")).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("John Doe")));
	}

	@Test
	void addFarmerStoresFarmer() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String farmerJson = objectMapper.writeValueAsString(farmer);

		mockMvc.perform(put("/farmers").contentType("application/json").content(farmerJson)).andExpect(status().isOk());

		verify(demoService, times(1)).addFarmer(any(Farmer.class));
	}
}
