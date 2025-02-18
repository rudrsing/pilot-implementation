
package com.demo.pilot.service;

import com.demo.pilot.model.PilotUser;
import java.util.Optional;

public interface PilotService {
	Optional<PilotUser> getPilotUser(Long id);

	void updatePilotUser(PilotUser pilotUser);
}
