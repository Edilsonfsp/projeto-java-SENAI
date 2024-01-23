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
		
		Optional<User> newObj = repository.findById(id);
		//return newObj.orElse(null);
        return newObj.orElseThrow(
            () -> new ObjectNotFoundException("Objeto não encontrado " + id + ", Tipo: " + User.class.getName())
            );
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public void delete(Integer id) {

		findById(id);
		repository.deleteById(id);
        
    }

    public User update(User obj, Integer id) {
		User newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(obj.getPassword());
		return repository.save(obj);	

    }

    public User create(User obj) {

		obj.setId(null);
		
		return repository.save(obj);

    }
    
}
