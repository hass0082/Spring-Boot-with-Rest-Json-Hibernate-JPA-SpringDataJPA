package com.spring.boot.learn.SpringBootLearn.dao;

import java.util.List;

import com.spring.boot.learn.SpringBootLearn.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
