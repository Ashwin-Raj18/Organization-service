package com.possoul.SpringBootRestCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.possoul.SpringBootRestCrud.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
