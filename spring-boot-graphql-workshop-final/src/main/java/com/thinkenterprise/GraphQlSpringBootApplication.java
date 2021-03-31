package com.thinkenterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import graphql.GraphQL;
import graphql.GraphQLContext;
import graphql.execution.instrumentation.Instrumentation;
import graphql.parser.Parser;
import graphql.schema.DataFetchingEnvironment;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

@SpringBootApplication
public class GraphQlSpringBootApplication {
	
	public static void main(String[] args) {		
		SpringApplication.run(GraphQlSpringBootApplication.class, args);	
	}
	
}
