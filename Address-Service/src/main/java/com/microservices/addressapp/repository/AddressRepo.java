package com.microservices.addressapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.microservices.addressapp.entity.Address;

import jakarta.websocket.server.PathParam;

public interface AddressRepo extends JpaRepository<Address, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT ea.id,ea.lane1,ea.lane2,ea.state,ea.zip FROM homies.address ea join homies.employee e on e.id=ea.employee_id where ea.id=?;  ")
Address  findAddressByEmployeeId(@PathParam (value="employeeId")int employeeId);

}
