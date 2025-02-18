
package com.demo.pilot.service;

import com.demo.pilot.model.PilotUser;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PilotServiceImpl implements PilotService {
	private Map<Long, PilotUser> pilotUserMap = new HashMap<>();

	@Override
	public Optional<PilotUser> getPilotUser(Long id) {
		return Optional.ofNullable(pilotUserMap.get(id));
	}

	@Override
	public void updatePilotUser(PilotUser pilotUser) {
		pilotUserMap.put(pilotUser.getId(), pilotUser);
	}
}
