package com.thinkenterprise.domain.route.graphql.error;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

/**  
* GraphQL Spring Boot Training 
* Design and Development by Michael Schäfer 
* Copyright (c) 2020 
* All Rights Reserved.
* 
* @author Michael Schäfer
*/

public class CustomGraphQLError implements GraphQLError {
   
    private static final long serialVersionUID = -6780513777815584903L;

    private String message;

    public CustomGraphQLError() {
        super();
    } 

    public CustomGraphQLError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

	@Override
	public ErrorType getErrorType() {
		return ErrorType.ExecutionAborted;
	} 
    
}