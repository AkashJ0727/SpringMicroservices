package com.microservices.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.employeeapp.entity.Employee;
import com.microservices.employeeapp.repository.EmployeeRepo;
import com.microservices.employeeapp.responce.AddressResponse;
import com.microservices.employeeapp.responce.EmployeeResponce;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${addressservice.base.url}")
	private String addressBaseUrl;

	public EmployeeResponce getEmployeeById(int id) {
//		AddressResponse addressResponse = new AddressResponse();
		Employee employee = employeeRepo.findById(id).get();  //DB call

		EmployeeResponce employeeResponce = modelMapper.map(employee, EmployeeResponce.class);
//		EmployeeResponce employeeResponce=new EmployeeResponce();
//		employeeResponce.setId(employee.getId());
//		employeeResponce.setName(employee.getName());
//		employeeResponce.setEmail(employee.getEmail());
//		employeeResponce.setBloodgroup(employee.getBloodgroup());

	AddressResponse 	addressResponse=restTemplate.getForObject(addressBaseUrl+"/address/{id}", AddressResponse.class, id); //external rest api call
		employeeResponce.setAddressResponse(addressResponse);
		return employeeResponce;
	}
}
