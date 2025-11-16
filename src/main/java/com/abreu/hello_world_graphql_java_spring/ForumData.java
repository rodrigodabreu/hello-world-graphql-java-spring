package com.abreu.hello_world_graphql_java_spring;

record Post(String id, String content) {
}

record Comment(String id, String content, String postId) {
}