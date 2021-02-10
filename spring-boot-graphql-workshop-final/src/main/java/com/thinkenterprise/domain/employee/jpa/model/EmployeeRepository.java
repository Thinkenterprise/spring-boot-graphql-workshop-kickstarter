package com.thinkenterprise.domain.employee.jpa.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.thinkenterprise.domain.route.jpa.model.Flight;
import com.thinkenterprise.domain.route.jpa.model.Route;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	@Query("select e from Employee e")
	List<Employee> findAll();
	
	@Query( "select e from Employee e where e.flight = :flight")
	List<Employee> findByFlight(@Param("flight") Flight flight);
}
