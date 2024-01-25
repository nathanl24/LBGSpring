package com.example.demo.rest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Vehicle;
import com.example.demo.services.VehicleService;

import java.util.List;

@RestController
public class VehicleController {
	
	private VehicleService service;

	public VehicleController(VehicleService service) {
		super();
		this.service = service;
	}

	// tells spring to listen for a GET request at /hello
	@GetMapping("/hello")
	public String greeting() {
		return "Hello, World!";
	}

	@GetMapping("/yo")
	public String informal() {
		return "Yo, World!";
	}

	@PostMapping("/create")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle newVehicle) {
		return this.service.createVehicle(newVehicle);
	}

	@GetMapping("/get")
	public List<Vehicle> getVehicles() {
		return this.service.getVehicles();
	}

	// 'id' -> index (for now)
	@GetMapping("/get/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable int id) {
		return this.service.getVehicle(id);
	}

	@PutMapping("/update/{id}")
	public Vehicle updateVehicle(@PathVariable int id, @RequestBody Vehicle newVehicle) {
		return this.service.updateVehicle(id, newVehicle);
	}

	@DeleteMapping("/remove/{id}")
	public Vehicle remove(@PathVariable int id) {
		return this.service.remove(id);
	}
	
}
