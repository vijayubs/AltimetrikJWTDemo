package com.altimetrik.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.altimetrik.exceptions.EmployeeNotfoundException;
import com.altimetrik.model.EmployeeModel;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	public static Map<Integer,EmployeeModel> employeesMap = new HashMap<Integer,EmployeeModel>();

	@Override
	public void createEmployee(EmployeeModel employeeModel) {
		employeesMap.put(employeeModel.getId(),employeeModel);
	}

	@Override
	public Collection<EmployeeModel> getAllEmployee() {
		return employeesMap.values();
	}
	
	@Override
	public EmployeeModel getEmployeeById(int id) {
		if(!employeesMap.containsKey(id))throw new EmployeeNotfoundException();
		return employeesMap.get(id);
	}

	@Override
	public void deleteEmployeeById(int id) {
		if(!employeesMap.containsKey(id))throw new EmployeeNotfoundException();
		employeesMap.remove(id);
	}

	
	
	
}
