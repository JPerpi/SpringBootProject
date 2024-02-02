package com.ieseljust.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ieseljust.project.model.Users;


public interface UsersRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByUsername(String username); 
}