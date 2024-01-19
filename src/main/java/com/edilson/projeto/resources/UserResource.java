package com.edilson.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edilson.projeto.entities.User;
import com.edilson.projeto.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
    private UserService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){

        User obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
        
    }

    @GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = this.service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
