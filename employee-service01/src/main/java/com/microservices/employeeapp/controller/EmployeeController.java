package com.microservices.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.employeeapp.responce.EmployeeResponce;
import com.microservices.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees/{id}")
	ResponseEntity<EmployeeResponce> getEmployeeDetails(@PathVariable("id") int id) {

		EmployeeResponce employeeResponce = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponce);
	}

}
