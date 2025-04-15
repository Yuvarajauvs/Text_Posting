package com.example.Yuva.Service;

import com.example.Yuva.Dto.UsersDto;
import com.example.Yuva.Model.LoginRequestDTO;
import com.example.Yuva.Model.Users;

public interface UserService {
    String registerUser(UsersDto userDTO);
    Users authenticate(LoginRequestDTO loginRequestDTO);
    Users findById(Long userId);
}
