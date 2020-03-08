package com.altimetrik.service;

import java.util.Collection;
import java.util.List;


import com.altimetrik.model.EmployeeModel;

public interface EmployeeService {
	
	public void createEmployee(EmployeeModel employeeModel);
	
	public Collection<EmployeeModel> getAllEmployee();
	
	public EmployeeModel getEmployeeById(int id);
	
	public void deleteEmployeeById(int  id);
	
}
