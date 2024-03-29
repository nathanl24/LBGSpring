package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Vehicle;
import com.example.demo.services.VehicleService;

@RestController
public class VehicleController {

	private VehicleService service;

	public VehicleController(VehicleService service) {
		super();
		this.service = service;
	}

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

	@GetMapping("/get/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable int id) {
		return this.service.getVehicle(id);
	}

//	@PutMapping("/update/{id}")
//	public Vehicle updateVehicle(@PathVariable int id, @RequestBody Vehicle newVehicle) {
//		return this.service.updateVehicle(id, newVehicle);
//	}
//
//	@DeleteMapping("/remove/{id}")
//	public Vehicle remove(@PathVariable int id) {
//		return this.service.remove(id);
//	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable int id, @RequestBody Vehicle newVehicle) {
		return this.service.updateVehicle(id, newVehicle);
	}

	@DeleteMapping("/remove/{id}")
	public boolean remove(@PathVariable int id) {
		return this.service.remove(id);
	}

}
