package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

}