package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Vehicle;

@Service
public class VehicleService {

	private List<Vehicle> vehicles = new ArrayList<>();

	public ResponseEntity<Vehicle> createVehicle(Vehicle newVehicle) {
		this.vehicles.add(newVehicle);
		Vehicle body = this.vehicles.get(this.vehicles.size() - 1);

		return new ResponseEntity<Vehicle>(body, HttpStatus.CREATED);
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public ResponseEntity<Vehicle> getVehicle(int id) {
		if (id < 0 || id >= this.vehicles.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Vehicle found = this.vehicles.get(id);

		return ResponseEntity.ok(found);
	}

	public Vehicle updateVehicle(int id, Vehicle newVehicle) {
		return this.vehicles.set(id, newVehicle);
	}

	public Vehicle remove(int id) {
		return this.vehicles.remove(id);
	}

}