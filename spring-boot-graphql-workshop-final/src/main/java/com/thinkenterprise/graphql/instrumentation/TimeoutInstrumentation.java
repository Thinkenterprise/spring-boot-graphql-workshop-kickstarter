package com.thinkenterprise.graphql.instrumentation;

import java.util.concurrent.TimeUnit;

import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.execution.instrumentation.parameters.InstrumentationFieldFetchParameters;
import graphql.schema.DataFetcher;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class TimeoutInstrumentation extends SimpleInstrumentation {
    @Override
    public DataFetcher<?> instrumentDataFetcher(
            DataFetcher<?> dataFetcher, InstrumentationFieldFetchParameters parameters
    ) {
    	
    	  return environment ->
            Observable.fromCallable(() -> dataFetcher.get(environment))
                .subscribeOn(Schedulers.computation())
                .timeout(10, TimeUnit.SECONDS)  
                .blockingFirst();
    }
}
