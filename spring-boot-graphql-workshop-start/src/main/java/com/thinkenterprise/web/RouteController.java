package com.thinkenterprise.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkenterprise.domain.route.jpa.model.Route;
import com.thinkenterprise.domain.route.jpa.model.repository.RouteRepository;



/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

/**
 * The Rest Controller works only, if you add @JsonIgnore on the recursive parts of the data model. 
 * */

@RestController
public class RouteController {

	private RouteRepository routeRepository;
	
	public RouteController(RouteRepository routeRepository) {
		this.routeRepository=routeRepository;
	}
		
	@GetMapping
	public List<Route> routes() {
		return routeRepository.findAll();
		
	}
	
}
