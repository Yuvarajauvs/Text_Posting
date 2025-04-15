package com.example.Yuva.ServiceImpl;

import com.example.Yuva.Dto.UsersDto;
import com.example.Yuva.Exception.InvalidCredentialsException;
import com.example.Yuva.Model.LoginRequestDTO;
import com.example.Yuva.Model.Users;
import com.example.Yuva.Repo.UsersRepo;
import com.example.Yuva.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepo userRepo;

    @Override
    public String registerUser(UsersDto userDTO) {
        if (userRepo.findByEmail(userDTO.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists!");
        }

        Users user = new Users();
        user.setEmail(userDTO.getEmail());
       // user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setAbout(userDTO.getAbout());

        userRepo.save(user);
        return "User registered successfully";
    }

    @Override
    public Users authenticate(LoginRequestDTO loginRequestDTO){

        Users user = userRepo.findByEmail(loginRequestDTO.getEmail());
        if (user != null && user.getPassword().equals(loginRequestDTO.getPassword())) {
            return user;
        }
        throw new InvalidCredentialsException("Invalid credentials");
    }

    @Override
    public Users findById(Long userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
