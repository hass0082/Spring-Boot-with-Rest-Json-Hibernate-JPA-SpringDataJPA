package com.spring.boot.learn.SpringBootLearn.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.learn.SpringBootLearn.entity.Employee;
import com.spring.boot.learn.SpringBootLearn.service.EmployeeService;

@RestController
public class SpringRestController {

	private EmployeeService employeeService;
	
	
	//inject employee dao
	@Autowired
	public SpringRestController(EmployeeService obj)
	{
		employeeService=obj;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeService.findAll();
	}
	

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	// add mapping for POST /employees - add new employee
	
		@PostMapping("/employees")
		public Employee addEmployee(@RequestBody Employee theEmployee) {
			
			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update
			
			theEmployee.setId(0);
			
			employeeService.save(theEmployee);
			
			return theEmployee;
		}
		
		// add mapping for PUT /employees - update existing employee
		
		@PutMapping("/employees")
		public Employee updateEmployee(@RequestBody Employee theEmployee) {
			
			employeeService.save(theEmployee);
			
			return theEmployee;
		}
		

		// add mapping for DELETE /employees/{employeeId} - delete employee
		
		@DeleteMapping("/employees/{employeeId}")
		public String deleteEmployee(@PathVariable int employeeId) {
			
			Employee tempEmployee = employeeService.findById(employeeId);
			
			// throw exception if null
			
			if (tempEmployee == null) {
				throw new RuntimeException("Employee id not found - " + employeeId);
			}
			
			employeeService.deleteById(employeeId);
			
			return "Deleted employee id - " + employeeId;
		}
	
	//Injecting properties 
	
	@Value("${coach.name}")
	private String coach;
	

	@Value("${team.name}")
	private String team;
	
	
	@GetMapping("/teamInfo")
	public String teamInfo()
	{
		return "Coach: "+coach+" Team: "+team;
	}
	
	
	@GetMapping("/map")
	public String index()
	{
		return "Spring rest";
	}
}