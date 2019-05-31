package com.spring.boot.learn.SpringBootLearn.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.spring.boot.learn.SpringBootLearn.entity.Employee;

public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//Define field for EntityManager  //Replacement of sessionFactory
	
	private EntityManager obj;
	
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntity)
	{
		obj=theEntity;
	}
	
	
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
