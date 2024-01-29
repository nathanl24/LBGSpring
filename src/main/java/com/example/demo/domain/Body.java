package com.example.demo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class Body {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private String shape;

	@JsonBackReference
	@OneToMany(mappedBy = "body")
	private List<Vehicle> vehicles;

	public Body() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

//	@Override
//	public String toString() {
//		return "[Make=" + shape + "]";
//	}

}
