package com.abreu.hello_world_graphql_java_spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ForumControlador {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;
    
    @QueryMapping //os nomes devem ser iguais aos do schema.graphqls
    public Post postById(@Argument String id) {
        return postService.postById(id);
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument String content) {
        return postService.createPost(content);
    }
    
    @MutationMapping
    public Collection<Comment> createComment(@Argument String content, @Argument String postId) {
        return commentService.createComment(content, postId);
    }

    //dataloader para comments de um post
    @SchemaMapping
    public Collection<Comment> comments(Post post){
        return commentService.findByPostId(post.id());
    }
}
