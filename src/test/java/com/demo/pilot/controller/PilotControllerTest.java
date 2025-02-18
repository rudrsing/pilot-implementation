
package com.demo.pilot.controller;

import com.demo.pilot.model.PilotUser;
import com.demo.pilot.service.PilotService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PilotControllerTest {

	@Mock
	private PilotService pilotService;

	@InjectMocks
	private PilotController pilotController;

	public PilotControllerTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetPilotUser() {
		PilotUser user = new PilotUser();
		user.setId(1L);
		user.setName("John Doe");

		when(pilotService.getPilotUser(1L)).thenReturn(Optional.of(user));

		ResponseEntity<PilotUser> response = pilotController.getPilotUser(1L);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals("John Doe", response.getBody().getName());
	}

	@Test
	public void testUpdatePilotUser() {
		PilotUser user = new PilotUser();
		user.setId(1L);
		user.setName("John Doe");

		doNothing().when(pilotService).updatePilotUser(user);

		ResponseEntity<Void> response = pilotController.updatePilotUser(user);
		assertEquals(200, response.getStatusCodeValue());
	}
}
