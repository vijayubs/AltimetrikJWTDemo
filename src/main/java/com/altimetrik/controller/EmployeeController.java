package com.altimetrik.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.exceptions.EmployeeNotfoundException;
import com.altimetrik.model.EmployeeModel;
import com.altimetrik.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeService;	
	

	@PostMapping("/employees")
	public ResponseEntity<Object> addNewEmployee(@RequestBody EmployeeModel employModel) {
		employeeService.createEmployee(employModel);
		return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<Object> getAllEmployees() {
		Collection<EmployeeModel> allEmployee = employeeService.getAllEmployee();
		if(allEmployee.size()==0) throw new EmployeeNotfoundException();
		
		return new ResponseEntity<>(allEmployee, HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeModel> getAllEmployees(@PathVariable("id") int  id) {
			return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeModel employeeRequestModel) { 
		
		EmployeeModel employee = employeeService.getEmployeeById(id);
		employee.setName(employeeRequestModel.getName());
		employee.setAge(employeeRequestModel.getAge());
		employee.setAddress(employeeRequestModel.getAddress());
		employee.setPhone(employeeRequestModel.getPhone());
		
		employeeService.deleteEmployeeById(id);
	
		employeeService.createEmployee(employee);
		
	      return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);
	   }

	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Object> deleteEmployees(@PathVariable("id") int id) {
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<>("Employee is deleted successfully", HttpStatus.OK);
	}

}
