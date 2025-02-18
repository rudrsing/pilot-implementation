
package com.demo.pilot.controller;

import com.demo.pilot.model.PilotUser;
import com.demo.pilot.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/api/pilots")
@Validated
public class PilotController {

	@Autowired
	private PilotService pilotService;
	

	/**
	 * Get the pilot user by ID
	 * 
	 * @param id the ID of the pilot user
	 * @return the pilot user
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PilotUser> getPilotUser(@PathVariable @NotNull Long id) {
		Optional<PilotUser> pilotUser = pilotService.getPilotUser(id);
		return pilotUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	/**
	 * Update the pilot user
	 * 
	 * @param pilotUser the pilot user to update
	 * @return the response entity
	 */
	@PutMapping("/")
	public ResponseEntity<Void> updatePilotUser(@RequestBody @Valid PilotUser pilotUser) {
		pilotService.updatePilotUser(pilotUser);
		return ResponseEntity.ok().build();
	}
}
