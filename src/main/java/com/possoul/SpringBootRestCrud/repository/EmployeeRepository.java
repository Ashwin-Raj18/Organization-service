package com.possoul.SpringBootRestCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.possoul.SpringBootRestCrud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//thats it no code, we get crud methods form jpa

}
