package com.edilson.projeto.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edilson.projeto.entities.User;
import com.edilson.projeto.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
    private UserService service;    

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
		
		User newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }
    
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

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@RequestBody User obj, @PathVariable Integer id) {

        // Certifique-se de que o objeto 'obj' contenha todas as informações necessárias para a atualização.
		
		User newObj = service.update(obj, id);
		return ResponseEntity.ok().body(newObj);

    }

}
