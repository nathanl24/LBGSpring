package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Body;
import com.example.demo.services.BodyService;

@RestController
@RequestMapping("/body")
public class BodyController {

	private BodyService service;

	public BodyController(BodyService service) {
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
	public ResponseEntity<Body> createBody(@RequestBody Body newBody) {
		return this.service.createBody(newBody);
	}

	@GetMapping("/get")
	public List<Body> getbodies() {
		return this.service.getBodies();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Body> getBody(@PathVariable int id) {
		return this.service.getBody(id);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Body> updateBody(@PathVariable int id, @RequestBody Body newBody) {
		return this.service.updateBody(id, newBody);
	}

	@DeleteMapping("/remove/{id}")
	public boolean remove(@PathVariable int id) {
		return this.service.remove(id);
	}

}
