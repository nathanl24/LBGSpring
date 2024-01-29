package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Body;

public interface BodyRepo extends JpaRepository<Body, Integer> {

}