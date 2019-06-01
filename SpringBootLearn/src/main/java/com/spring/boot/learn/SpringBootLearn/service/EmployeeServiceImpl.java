package com.spring.boot.learn.SpringBootLearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.learn.SpringBootLearn.dao.EmployeeDAO;
import com.spring.boot.learn.SpringBootLearn.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	
	//inject employee dao
	@Autowired   //Adding bean id @Qualifier
	public EmployeeServiceImpl(@Qualifier("employeeDAO_JPA_Implt") EmployeeDAO employe)
	{
		employeeDAO=employe;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}