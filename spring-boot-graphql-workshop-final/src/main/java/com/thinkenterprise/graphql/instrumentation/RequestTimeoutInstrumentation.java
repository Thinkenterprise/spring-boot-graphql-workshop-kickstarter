package com.thinkenterprise.graphql.instrumentation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import graphql.ExecutionResult;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.execution.AbortExecutionException;
import graphql.execution.instrumentation.InstrumentationContext;
import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionParameters;
import graphql.execution.instrumentation.parameters.InstrumentationFieldCompleteParameters;
import graphql.execution.instrumentation.parameters.InstrumentationFieldFetchParameters;
import graphql.execution.instrumentation.parameters.InstrumentationFieldParameters;
import graphql.schema.DataFetcher;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class RequestTimeoutInstrumentation extends SimpleInstrumentation {

	protected final static Logger logger = LoggerFactory.getLogger(RequestTimeoutInstrumentation.class); 
	
	private LocalDateTime startTime;
	private Long timeout;
	
	public RequestTimeoutInstrumentation(Long timeout) {
		this.timeout = timeout;
	}
		
	@Override
	public InstrumentationContext<ExecutionResult> beginExecution(InstrumentationExecutionParameters parameters) {
		startTime = LocalDateTime.now();
		logger.info(startTime.toString());
		return super.beginExecution(parameters);
	}

	@Override
	public InstrumentationContext<ExecutionResult> beginField(InstrumentationFieldParameters parameters) {
		
		Long timeDifference = Duration.between(startTime, LocalDateTime.now()).toSeconds();
		logger.info(timeDifference.toString());
		
		if(timeDifference >= timeout) 
			throw new AbortExecutionException(List.of(createGraphQLError(timeDifference)));		
			
		return super.beginField(parameters);
	}
	
	@Override
    public DataFetcher<?> instrumentDataFetcher(
            DataFetcher<?> dataFetcher, InstrumentationFieldFetchParameters parameters
    ) {
    	
    	  return environment ->
            Observable.fromCallable(() -> dataFetcher.get(environment))
                .subscribeOn(Schedulers.computation())
                .timeout(timeout, TimeUnit.SECONDS)  
                .blockingFirst();
    }

	@Override
	public InstrumentationContext<ExecutionResult> beginFieldComplete(
			InstrumentationFieldCompleteParameters parameters) {
		
		Long timeDifference = Duration.between(startTime, LocalDateTime.now()).toSeconds();		
		logger.info(timeDifference.toString());
		
		if((parameters.getFetchedValue()==null)&&(timeDifference >= timeout)) 
			throw new AbortExecutionException(List.of(createGraphQLError(timeDifference)));		
		
		return super.beginFieldComplete(parameters);
	}
	
	private GraphQLError createGraphQLError(Long timeDifference) {
		return GraphqlErrorBuilder.newError().message("Execution time: %d seconds timeout: %d seconds", Long.valueOf(timeDifference), Long.valueOf(timeout)).build();
	}
	
}
