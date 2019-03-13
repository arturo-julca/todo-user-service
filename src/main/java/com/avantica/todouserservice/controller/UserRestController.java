package com.avantica.todouserservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avantica.todouserservice.model.AppUser;
import com.avantica.todouserservice.repository.AppUserRepository;

@RestController
@RequestMapping({"/"})
public class UserRestController {

	private AppUserRepository userRepository;
	
	UserRestController(AppUserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@GetMapping(path = {"{id}"})
    public ResponseEntity<AppUser> findById(@PathVariable long id){
    	return userRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
	
	@GetMapping(path = {"username/{username}"})
    public ResponseEntity<AppUser> findByUsername(@PathVariable String username){
    	return userRepository.findByUsername(username)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
