
package com.demo.pilot.service;

import com.demo.pilot.model.Farmer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoServiceTest {

	private DemoService demoService;

	@BeforeEach
	void setUp() {
		demoService = new DemoService();
	}

	@Test
	void getFarmerReturnsFarmerWhenExists() {
		Farmer farmer = new Farmer();
		farmer.setId("1");
		farmer.setName("John Doe");
		demoService.addFarmer(farmer);

		Farmer result = demoService.getFarmer("1");

		assertNotNull(result);
		assertEquals("John Doe", result.getName());
	}

	@Test
	void getFarmerReturnsNullWhenNotExists() {
		Farmer result = demoService.getFarmer("2");

		assertNull(result);
	}

	@Test
	void addFarmerStoresFarmer() {
		Farmer farmer = new Farmer();
		farmer.setId("3");
		farmer.setName("Jane Doe");

		demoService.addFarmer(farmer);

		Farmer result = demoService.getFarmer("3");
		assertNotNull(result);
		assertEquals("Jane Doe", result.getName());
	}

	@Test
	void addFarmerOverwritesExistingFarmer() {
		Farmer farmer1 = new Farmer();
		farmer1.setId("4");
		farmer1.setName("John Smith");
		demoService.addFarmer(farmer1);

		Farmer farmer2 = new Farmer();
		farmer2.setId("4");
		farmer2.setName("Jane Smith");
		demoService.addFarmer(farmer2);

		Farmer result = demoService.getFarmer("4");
		assertNotNull(result);
		assertEquals("Jane Smith", result.getName());
	}
}
