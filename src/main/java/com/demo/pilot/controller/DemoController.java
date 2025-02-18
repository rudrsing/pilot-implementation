
package com.demo.pilot.controller;

import com.demo.pilot.model.Farmer;
import com.demo.pilot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmers")
public class DemoController {

	private final DemoService demoService;

	@Autowired
	public DemoController(DemoService demoService) {
		this.demoService = demoService;
	}

	@GetMapping("/{id}")
	public Farmer getFarmer(@PathVariable String id) {
		return demoService.getFarmer(id);
	}

	@PutMapping
	public void addFarmer(@RequestBody Farmer farmer) {
		demoService.addFarmer(farmer);
	}
}
