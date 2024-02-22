package com.microservices.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.employeeapp.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
