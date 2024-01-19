package com.edilson.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilson.projeto.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
 
}
