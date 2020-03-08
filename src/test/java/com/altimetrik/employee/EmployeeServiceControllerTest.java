package com.altimetrik.employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.altimetrik.AbstractTest;
import com.altimetrik.model.EmployeeModel;

public class EmployeeServiceControllerTest extends AbstractTest {
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createemployee() throws Exception {
		String uri = "/employees";
		EmployeeModel employee = new EmployeeModel();
		employee.setId(1);
		employee.setName("employee1");
		employee.setAge(22);
		employee.setAddress("noida");
		employee.setPhone(987);
		String inputJson = super.mapToJson(employee);

		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Employee is created successfully");
	}

	
	  @Test 
	  public void getEmployeeList() throws Exception 
	  { 
		 createemployee();
		  
		String uri = "/employees";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
		EmployeeModel[] employeeList = super.mapFromJson(content, EmployeeModel[].class);
		assertTrue(employeeList.length > 0);
	}
	 
	  
		
	@Test
	public void updateEmployee() throws Exception {
		
		createemployee();
		
		String uri = "/employees/1";
		EmployeeModel employee = new EmployeeModel();
		employee.setId(1);
		employee.setName("employee1");
		employee.setAge(22);
		employee.setAddress("noida");
		employee.setPhone(987);
		String inputJson = super.mapToJson(employee);
		
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Employee is updated successsfully");
	}
	

	@Test
	public void deleteemployee() throws Exception {
		
		createemployee();
		
		String uri = "/employees/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Employee is deleted successfully");
	}	 

}