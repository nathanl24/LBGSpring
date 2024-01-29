package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private String make;

	private String model;

	@JsonManagedReference
	@ManyToOne
	private Body body;

	public Vehicle() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

//	@Override
//	public String toString() {
//		return "Vehicle [Make=" + make + ", Model=" + model + "]";
//	}
}