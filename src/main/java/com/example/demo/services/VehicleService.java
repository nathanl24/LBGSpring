package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Vehicle;
import com.example.demo.repos.VehicleRepo;

@Service
public class VehicleService {

	private VehicleRepo repo;

	public VehicleService(VehicleRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Vehicle> createVehicle(Vehicle newVehicle) {
		Vehicle created = this.repo.save(newVehicle);
		return new ResponseEntity<Vehicle>(created, HttpStatus.CREATED);
	}

	public List<Vehicle> getVehicles() {
		return this.repo.findAll();
	}

	public ResponseEntity<Vehicle> getVehicle(int id) {
		// returns a box that might have a hero in it
		Optional<Vehicle> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a hero
			return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Vehicle body = found.get();

		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Vehicle> updateVehicle(int id, Vehicle newVehicle) {
		// returns a box that might have a hero in it
		Optional<Vehicle> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if it's found a hero
			return new ResponseEntity<Vehicle>(HttpStatus.NOT_FOUND);
		}

		// attempts to pull the contents out of the box
		Vehicle existing = found.get();

		if (newVehicle.getMake() != null) {
			existing.setMake(newVehicle.getMake());
		}

		if (newVehicle.getModel() != null) {
			existing.setModel(newVehicle.getModel());
		}

		Vehicle updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

//	private List<Vehicle> vehicles = new ArrayList<>();
//
//	public ResponseEntity<Vehicle> createVehicle(Vehicle newVehicle) {
//		this.vehicles.add(newVehicle);
//		Vehicle body = this.vehicles.get(this.vehicles.size() - 1);
//
//		return new ResponseEntity<Vehicle>(body, HttpStatus.CREATED);
//	}
//
//	public List<Vehicle> getVehicles() {
//		return vehicles;
//	}
//
//	public ResponseEntity<Vehicle> getVehicle(int id) {
//		if (id < 0 || id >= this.vehicles.size()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		Vehicle found = this.vehicles.get(id);
//
//		return ResponseEntity.ok(found);
//	}
//
//	public Vehicle updateVehicle(int id, Vehicle newVehicle) {
//		return this.vehicles.set(id, newVehicle);
//	}
//
//	public Vehicle remove(int id) {
//		return this.vehicles.remove(id);
//	}

}