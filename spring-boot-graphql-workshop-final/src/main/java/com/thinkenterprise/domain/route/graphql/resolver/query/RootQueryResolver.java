package com.thinkenterprise.domain.route.graphql.resolver.query;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.thinkenterprise.domain.route.exception.RouteException;
import com.thinkenterprise.domain.route.model.jpa.Route;
import com.thinkenterprise.domain.route.model.jpa.RouteRepository;
import com.thinkenterprise.graphql.context.CustomGraphQLServletContext;
import com.thinkenterprise.graphql.error.CustomGraphQLError;

import graphql.GraphQLError;
import graphql.kickstart.tools.GraphQLQueryResolver;
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
public class RootQueryResolver implements GraphQLQueryResolver {
	
	protected static Logger log = LoggerFactory.getLogger(RootQueryResolver.class);
	
	private RouteRepository routeRepository; 
	
	@Value("${route.exception}")
	private Boolean exception;
	
	@Autowired
	public RootQueryResolver(RouteRepository routeRepository) {
		this.routeRepository=routeRepository;	
	}
	
//	public Route route(String flightNumber) {
//		return routeRepository.findByFlightNumber(flightNumber);
//	}
	
	public CompletableFuture<Route> route(String flightNumber) {
		
		return CompletableFuture.supplyAsync(() -> routeRepository.findByFlightNumber(flightNumber));
		
	}
	
	//@PreAuthorize("hasRole('read')")
	//@PreAuthorize("hasAuthority('SCOPE_read')")
	//public List<Route> routes(DataFetchingEnvironment dataFetchingEnvironment) {
	
	public List<Route> routes(int page, int size)  {
		
	//CustomGraphQLServletContext customGraphQLServletContext = (CustomGraphQLServletContext) dataFetchingEnvironment.getContext();
	//log.info(customGraphQLServletContext.getUserId());
		Pageable pageable = PageRequest.of(page, size);
		
		if(!exception) {
			Page<Route> pageResult = routeRepository.findAll(pageable);
			return pageResult.toList();
		}
		else 
			throw new RouteException("RouteException: Route Data Fetching doesent work");
	} 
	
	
	@ExceptionHandler(RouteException.class)
	public GraphQLError exception(RouteException routeException) {
		return new CustomGraphQLError("CustomGraphQLError: Exception Handler");
	}
	
	
	
}
