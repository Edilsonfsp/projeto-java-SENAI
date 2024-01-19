package com.edilson.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilson.projeto.entities.User;
import com.edilson.projeto.repositories.UserRepository;
import com.edilson.projeto.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Integer id) {
		
		Optional<User> obj = repository.findById(id);
		//return obj.orElse(null);
        return obj.orElseThrow(
            () -> new ObjectNotFoundException("Objeto não encontrado " + id + ", Tipo: " + User.class.getName())
            );
    }

    public List<User> findAll() {
        return repository.findAll();
    }
    
}
