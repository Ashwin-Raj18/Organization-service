package com.possoul.SpringBootRestCrud.service;

import java.util.List;

import com.possoul.SpringBootRestCrud.dto.EmployeeInfo;
import com.possoul.SpringBootRestCrud.model.Employee;


public interface EmployeeService {
	
public List<EmployeeInfo> findAll(boolean isCachable, int pageNo, int pageSize);

public EmployeeInfo findById(int theId);


public void deleteById(int theId);

}
