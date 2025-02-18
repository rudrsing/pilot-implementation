
package com.demo.pilot.service;

import com.demo.pilot.model.Farmer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemoService {
	private final Map<String, Farmer> farmerMap = new HashMap<>();

	public Farmer getFarmer(String id) {
		return farmerMap.get(id);
	}

	public void addFarmer(Farmer farmer) {
		farmerMap.put(farmer.getId(), farmer);
	}
	
	public void updateFarmer(Farmer farmer) {
		farmerMap.put(farmer.getId(), farmer);
	}

}
