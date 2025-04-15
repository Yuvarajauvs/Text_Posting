package com.example.Yuva.Controller;

import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.PostDTO;
import com.example.Yuva.Model.PostRequest;
import com.example.Yuva.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin
public class PostController {

    @Autowired
    private PostService postService;

    // Create a new post
    @PostMapping("/create")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostRequest postRequest) {
        PostDTO postDTO = postService.createPostFromRequest(postRequest);
        return ResponseEntity.ok(postDTO);
    }
    // Get all posts
    @GetMapping("/all")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    // Get post by ID
    @GetMapping("/{pid}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long pid) {
        PostDTO postDTO = postService.getPostById(pid);
        return ResponseEntity.ok(postDTO);
    }
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(postService.getPostsByUserId(userId));
    }


}
