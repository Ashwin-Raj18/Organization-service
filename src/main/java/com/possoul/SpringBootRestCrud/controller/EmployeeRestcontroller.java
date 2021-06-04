package com.possoul.SpringBootRestCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.possoul.SpringBootRestCrud.dto.EmployeeInfo;
import com.possoul.SpringBootRestCrud.model.Employee;
import com.possoul.SpringBootRestCrud.service.EmployeeService;

@RestController    //@Responebody is not needed
@RequestMapping("/api")
public class EmployeeRestcontroller {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
    private CacheManager cacheManager;
	
	@GetMapping("/employees/{pageNo}/{pageSize}")
	public List<EmployeeInfo> findAll(int pageNo, int pageSize){
		return employeeService.findAll(true,pageNo,pageSize);
		                                       //converting page to list
	}

	@GetMapping("/employees/{employeeId}")
	public EmployeeInfo getEmployee(@PathVariable int employeeId) {
		
		EmployeeInfo EmployeeInfo = employeeService.findById(employeeId);
		
		return EmployeeInfo;
	}
	
	
	@GetMapping("/getCached/{cacheKey}")
	public EmployeeInfo getCachedObj(@PathVariable int cacheKey) {
		 //Access cache instance by name
        Cache cache = cacheManager.getCache("employeeCache");
         
        //Add entry to cache
        //cache.put(3, new Employee("Baba", "Charles", "baba@123"));
         
        //Get entry from cache
        return (EmployeeInfo) cache.get(cacheKey).get();
        
        	
	}
		
}
