package com.abreu.hello_world_graphql_java_spring;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
