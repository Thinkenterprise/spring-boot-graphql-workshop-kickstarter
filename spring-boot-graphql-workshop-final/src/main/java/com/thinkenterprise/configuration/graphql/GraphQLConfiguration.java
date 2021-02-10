package com.thinkenterprise.configuration.graphql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestSubscription;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import com.thinkenterprise.domain.employee.jpa.model.Pilot;
import com.thinkenterprise.domain.route.graphql.context.CustomGraphQLServletContextBuilder;
import com.thinkenterprise.domain.route.graphql.publisher.ProjectReactorRouteSubscriptionNotifier;
import com.thinkenterprise.domain.route.graphql.publisher.RouteSubscriptionNotifier;

import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;
import graphql.kickstart.tools.SchemaParserDictionary;

/**
 * GraphQL Spring Boot Training Design and Development by Michael Schäfer
 * Copyright (c) 2020 All Rights Reserved.
 * 
 * @author Michael Schäfer
 */

@Configuration
public class GraphQLConfiguration {

	@Bean
	public SchemaParserDictionary schemaParserDictionary() {
		return new SchemaParserDictionary().add(Pilot.class);
	}

	@Bean
	public RouteSubscriptionNotifier projectReactorRouteSubscriptionNotifier() {
		return new ProjectReactorRouteSubscriptionNotifier();
	}

	@Bean
	public GraphQLServletContextBuilder graphQLServletContextBuilder() {
		return new CustomGraphQLServletContextBuilder();
	}
	
	@Bean
	public GraphQLTestTemplate graphQLTestTemplate() {
		return null;
	}
	@Bean
	public GraphQLTestSubscription graphQLTestSubscription() {
		return null;
	}
	

}