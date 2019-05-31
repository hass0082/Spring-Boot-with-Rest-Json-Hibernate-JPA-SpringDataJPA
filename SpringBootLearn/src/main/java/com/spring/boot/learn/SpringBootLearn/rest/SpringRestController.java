package com.spring.boot.learn.SpringBootLearn.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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