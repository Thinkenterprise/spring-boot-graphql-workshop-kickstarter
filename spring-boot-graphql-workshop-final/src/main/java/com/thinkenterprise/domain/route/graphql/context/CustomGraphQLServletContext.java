package com.thinkenterprise.domain.route.graphql.context;

import java.util.List;

import java.util.Map;
import java.util.Optional;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.dataloader.DataLoaderRegistry;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.GraphQLServletContext;


/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public class CustomGraphQLServletContext implements GraphQLServletContext {

	private String userId;
	private DefaultGraphQLServletContext defaultGraphQLServletContext;
	
	public CustomGraphQLServletContext() {
		super();
	}
	
	public CustomGraphQLServletContext(String userId, DefaultGraphQLServletContext defaultGraphQLServletContext) {
		super();
		this.userId = userId;
		this.defaultGraphQLServletContext = defaultGraphQLServletContext;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public Optional<Subject> getSubject() {
		return defaultGraphQLServletContext.getSubject();
	}

	@Override
	public Optional<DataLoaderRegistry> getDataLoaderRegistry() {
		return defaultGraphQLServletContext.getDataLoaderRegistry();
	}

	@Override
	public List<Part> getFileParts() {
		return defaultGraphQLServletContext.getFileParts();
	}

	@Override
	public Map<String, List<Part>> getParts() {
		return defaultGraphQLServletContext.getParts();
	}

	@Override
	public HttpServletRequest getHttpServletRequest() {
		
		return defaultGraphQLServletContext.getHttpServletRequest();
	}

	@Override
	public HttpServletResponse getHttpServletResponse() {
		return defaultGraphQLServletContext.getHttpServletResponse();
	}

}
