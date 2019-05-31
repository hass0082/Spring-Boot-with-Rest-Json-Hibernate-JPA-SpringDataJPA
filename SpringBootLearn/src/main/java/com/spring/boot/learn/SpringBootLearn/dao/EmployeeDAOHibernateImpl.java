package com.spring.boot.learn.SpringBootLearn.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<Employee> findAll() {
	
		//get the current hibernate session
		Session currentSession=obj.unwrap(Session.class);
		
		//Create a query
		Query <Employee> theQuery=
					currentSession.createQuery("from Employee", Employee.class);
		
		//execute
		List<Employee> employees=theQuery.getResultList();
		
		//return the results
		
		return employees;
	}

}
