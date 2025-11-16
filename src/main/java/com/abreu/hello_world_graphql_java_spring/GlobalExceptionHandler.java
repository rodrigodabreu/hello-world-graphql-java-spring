package com.abreu.hello_world_graphql_java_spring;

import org.springframework.graphql.execution.ErrorType;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public GraphQLError handlePostNotFoundException(NotFoundException ex){
    return GraphqlErrorBuilder.newError()
        .message(ex.getMessage())
        .errorType(ErrorType.NOT_FOUND)
        .build();
  }

}
