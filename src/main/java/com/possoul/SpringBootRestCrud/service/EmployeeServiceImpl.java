package com.possoul.SpringBootRestCrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.possoul.SpringBootRestCrud.model.Employee;
import com.possoul.SpringBootRestCrud.dto.EmployeeInfo;
import com.possoul.SpringBootRestCrud.exceptions.ResourceNotFoundException;
import com.possoul.SpringBootRestCrud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	//@Transactional  is provided by JPA repository outOfthe box
	public List<EmployeeInfo> findAll(boolean isCachable,int pageNo, int pageSize) {
		
		//adding pagination
		//pageNo starts from 0
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("employeeId"));
		Page<Employee> ePage =  employeeRepository.findAll(paging);
		List<Employee> eList = ePage.getContent();
		List<EmployeeInfo> eInfos = new ArrayList<>();
		for(Employee e : eList) {
			EmployeeInfo eI = new EmployeeInfo();
			eI.firstName = e.getFirstName();
			eI.department = e.getDepartment().getDepartmentName();
			eI.email = e.getEmail();
			eI.lastName = e.getLastName();
			eI.hireDate = e.getHireDate();
			eI.ph = e.getPhoneNumber();
			eI.salary = e.getSalary();
			eI.employeeId = e.getEmployeeId();
			eInfos.add(eI);
		}
		return eInfos;
		
	}

	@Override
	@Cacheable(cacheNames="employeeCache", key="#theId")
	public EmployeeInfo findById(int theId) {
	
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee e = null;
		EmployeeInfo eI = new EmployeeInfo();
		if(result.isPresent()){
			e = result.get();
			eI.firstName = e.getFirstName();
			eI.department = e.getDepartment().getDepartmentName();
			eI.email = e.getEmail();
			eI.lastName = e.getLastName();
			eI.hireDate = e.getHireDate();
			eI.ph = e.getPhoneNumber();
			eI.salary = e.getSalary();
			eI.employeeId = e.getEmployeeId();
		}else{
			throw new ResourceNotFoundException("employeee not found for id  "+theId);
		}
		return eI;	
	}


	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

}
