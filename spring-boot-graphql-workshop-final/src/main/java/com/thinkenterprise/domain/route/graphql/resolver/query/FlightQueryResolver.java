package com.thinkenterprise.domain.route.graphql.resolver.query;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.dataloader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thinkenterprise.domain.employee.model.jpa.Employee;
import com.thinkenterprise.domain.employee.model.jpa.EmployeeRepository;
import com.thinkenterprise.domain.route.model.jpa.Flight;
import com.thinkenterprise.domain.route.model.jpa.Route;
import com.thinkenterprise.domain.route.model.jpa.RouteRepository;
import com.thinkenterprise.domain.route.service.DiscountService;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;


/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/


@Component
public class FlightQueryResolver implements GraphQLResolver<Flight> {

	
    private EmployeeRepository employeeRepository;
    private RouteRepository routeRepository;
    private DiscountService discountService;
   
    @Autowired
    public FlightQueryResolver(RouteRepository routeRepository,
    						   EmployeeRepository employeeRepository,
    						   DiscountService discountService) {
        this.employeeRepository=employeeRepository;
        this.routeRepository=routeRepository;
        this.discountService=discountService;
        
    }

    public List<Employee> employees(Flight flight) {
        return employeeRepository.findByFlight(flight);
    }
    
    public Route route(Flight flight) {
    	return routeRepository.findById(flight.getRoute().getId()).get();
    }
    
    /*
    public Float discount(Flight flight) {
		return discountService.getDiscount(flight.getId());
	}
    */
    
    public CompletableFuture<Float> discount(Flight flight, DataFetchingEnvironment dataFetchingEnvironment) {

		DataLoader<Long, Float> discoutDataLoader = dataFetchingEnvironment.getDataLoader("discount");
		return discoutDataLoader.load(flight.getId());

	}
    
   
}