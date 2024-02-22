package com.microservices.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.addressapp.entity.Address;
import com.microservices.addressapp.repository.AddressRepo;
import com.microservices.addressapp.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	public AddressResponse findAddressbyEmployeeId(int employeeId) {
		
	Address address=addressRepo.findAddressByEmployeeId(employeeId);
		AddressResponse addressResponse=modelMapper.map(address, AddressResponse.class);
		return addressResponse;
	}
}
