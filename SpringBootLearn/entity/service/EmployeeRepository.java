package com.spring.boot.learn.SpringBootLearn.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.learn.SpringBootLearn.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
