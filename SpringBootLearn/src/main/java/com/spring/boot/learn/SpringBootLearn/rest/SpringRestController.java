package com.spring.boot.learn.SpringBootLearn.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.learn.SpringBootLearn.dao.EmployeeDAO;
import com.spring.boot.learn.SpringBootLearn.entity.Employee;

@RestController
public class SpringRestController {

	private EmployeeDAO employeeDAO;
	
	
	//inject employee dao
	@Autowired
	public SpringRestController(EmployeeDAO employe)
	{
		employeeDAO=employe;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{
		return employeeDAO.findAll();
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