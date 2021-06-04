package com.possoul.SpringBootRestCrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.possoul.SpringBootRestCrud.dto.DepartmentInfo;
import com.possoul.SpringBootRestCrud.model.Department;
import com.possoul.SpringBootRestCrud.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository deptRepo;

	@Override
	public List<DepartmentInfo> findAll(){
		//employees should not load (default lazy as one to many)
		List<Department> depts = deptRepo.findAll();
		List<DepartmentInfo> deptRes = new ArrayList<DepartmentInfo>(); 
		for(Department dept : depts) {
			DepartmentInfo deptInfo = new DepartmentInfo();
			deptInfo.deptId = dept.getDepartmentId();
			deptInfo.deptName = dept.getDepartmentName();
			deptInfo.locationName = dept.getLocation().getCity();
			deptRes.add(deptInfo);
		}
		return deptRes;
	}

}
