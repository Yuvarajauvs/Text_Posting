package com.example.Yuva.Repo;

import com.example.Yuva.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    Optional<Users> findById(Long id);
}
