package com.possoul.SpringBootRestCrud.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EmployeeInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	public int employeeId;
	public String firstName;
	public String lastName;
	public String email;
	public BigDecimal salary;
	public String department;
	public Date hireDate;
	public String ph;

}
