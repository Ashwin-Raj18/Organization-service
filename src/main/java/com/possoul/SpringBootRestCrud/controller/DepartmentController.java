package com.possoul.SpringBootRestCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.possoul.SpringBootRestCrud.dto.DepartmentInfo;
import com.possoul.SpringBootRestCrud.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@GetMapping("/getAllDepartmetInfo")
	public List<DepartmentInfo> getAll(){
		return deptService.findAll();
	}
	
}
