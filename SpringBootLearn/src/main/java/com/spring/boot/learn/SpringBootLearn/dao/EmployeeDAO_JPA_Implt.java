package com.spring.boot.learn.SpringBootLearn.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.learn.SpringBootLearn.entity.Employee;

@Repository
public class EmployeeDAO_JPA_Implt implements EmployeeDAO {

		// define field for entitymanager	
		private EntityManager entityManager;
			
		// set up constructor injection
		@Autowired
		public EmployeeDAO_JPA_Implt(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
		
		@Override
		public List<Employee> findAll() {

			
			// create a query
			Query theQuery = (Query) entityManager.createQuery("from Employee");
			
			// execute query and get result list
			List<Employee> employees = theQuery.getResultList();
			
			// return the results		
			return employees;
		}


		@Override
		public Employee findById(int theId) {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public void save(Employee theEmployee) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void deleteById(int theId) {
			// TODO Auto-generated method stub
			
		}

	

}