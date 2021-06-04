package com.possoul.SpringBootRestCrud.service;

import java.util.List;

import com.possoul.SpringBootRestCrud.dto.DepartmentInfo;

public interface DepartmentService {
	public List<DepartmentInfo> findAll();
}
