package com.example.Yuva.ServiceImpl;

import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.PostDTO;
import com.example.Yuva.Model.PostRequest;
import com.example.Yuva.Model.Users;
import com.example.Yuva.Repo.PostRepo;
import com.example.Yuva.Repo.UsersRepo;
import com.example.Yuva.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public PostDTO createPostFromRequest(PostRequest postRequest) {
        // Fetch the user
        Users user = usersRepo.findById(postRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + postRequest.getUserId()));

        // Create post and set user and timestamp
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setAbout(postRequest.getAbout());
        post.setUsers(user);
        post.setCreatedAt(LocalDateTime.now()); // set time manually

        Post savedPost = postRepo.save(post);

        return new PostDTO(
                savedPost.getPid(),
                savedPost.getTitle(),
                savedPost.getAbout(),
                user.getUsername(),
                savedPost.getCreatedAt()
        );
    }


    @Override
    public List<PostDTO> getAllPosts() {
        return postRepo.findAll().stream()
                .map(post -> new PostDTO(post.getPid(), post.getTitle(), post.getAbout(),
                        post.getUsers().getUsername(), post.getCreatedAt()))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long pid) {
        Post post = postRepo.findById(pid)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        return new PostDTO(post.getPid(), post.getTitle(), post.getAbout(),
                post.getUsers().getUsername(), post.getCreatedAt());
    }

    @Override
    public List<PostDTO> getPostsByUserId(Long userId) {
        Users user = usersRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Post> posts = postRepo.findByUsers(user);

        return posts.stream().map(post -> {
            PostDTO dto = new PostDTO(
                    post.getPid(),
                    post.getTitle(),
                    post.getAbout(),
                    post.getUsers().getUsername()
            );
            dto.setLikeCount((long) post.getLikes().size()); // If you want like count
            return dto;
        }).toList();
    }


}
