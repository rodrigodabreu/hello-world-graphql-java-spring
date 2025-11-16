package com.abreu.hello_world_graphql_java_spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
class PostService {
    Map<String, Post> posts = new HashMap<>();

    Collection<Post> createPost(final String content) {
        var newPost = new Post(UUID.randomUUID().toString(), content);
        posts.put(newPost.id(), newPost);
        return posts.values();
    }
    
    Post postById(String id) {
        return posts.get(id);
    }

    void deletePost(String id) {
        posts.remove(id);
    }
    
}
@Service
class CommentService {
        Map<String, Comment> comments = new HashMap<>();

        Collection<Comment> createComment(final String content,final  String postId) {
            var newComment = new Comment(UUID.randomUUID().toString(), content, postId);
            comments.put(newComment.id(), newComment);
            return comments.values();
        }

        public Collection<Comment> findByPostId(String postId) {
            return comments.values().stream()
                .filter(comment -> comment.postId().equals(postId))
                .toList();
        }

}
