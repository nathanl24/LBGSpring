package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Body;
import com.example.demo.repos.BodyRepo;

@Service
public class BodyService {

	private BodyRepo repo;

	public BodyService(BodyRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Body> createBody(Body newBody) {
		Body created = this.repo.save(newBody);
		return new ResponseEntity<Body>(created, HttpStatus.CREATED);
	}

	public List<Body> getBodies() {
		return this.repo.findAll();
	}

	public ResponseEntity<Body> getBody(int id) {

		Optional<Body> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Body>(HttpStatus.NOT_FOUND);
		}

		Body body = found.get();

		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Body> updateBody(int id, Body newBody) {

		Optional<Body> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Body>(HttpStatus.NOT_FOUND);
		}

		Body existing = found.get();

		if (newBody.getShape() != null) {
			existing.setShape(newBody.getShape());
		}

		if (newBody.getShape() != null) {
			existing.setShape(newBody.getShape());
		}

		Body updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

}
