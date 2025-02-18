
package com.demo.pilot.service;

import com.demo.pilot.model.PilotUser;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PilotServiceTest {

	private PilotService pilotService = new PilotServiceImpl();

	@Test
	public void testGetPilotUser() {
		PilotUser user = new PilotUser();
		user.setId(1L);
		user.setName("John Doe");
		pilotService.updatePilotUser(user);

		Optional<PilotUser> retrievedUser = pilotService.getPilotUser(1L);
		assertTrue(retrievedUser.isPresent());
		assertEquals("John Doe", retrievedUser.get().getName());
	}

	@Test
	public void testUpdatePilotUser() {
		PilotUser user = new PilotUser();
		user.setId(1L);
		user.setName("John Doe");
		pilotService.updatePilotUser(user);

		Optional<PilotUser> retrievedUser = pilotService.getPilotUser(1L);
		assertTrue(retrievedUser.isPresent());
		assertEquals("John Doe", retrievedUser.get().getName());
	}
}
