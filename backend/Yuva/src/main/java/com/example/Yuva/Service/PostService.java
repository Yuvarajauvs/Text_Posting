package com.example.Yuva.Service;

import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.PostDTO;
import com.example.Yuva.Model.PostRequest;

import java.util.List;

public interface PostService {
    PostDTO createPostFromRequest(PostRequest postRequest);
    //PostDTO createPost(Post post);  // Create a post
    List<PostDTO> getAllPosts();  // Get all posts
    PostDTO getPostById(Long pid);  // Get post by ID
    public List<PostDTO> getPostsByUserId(Long userId);

}
