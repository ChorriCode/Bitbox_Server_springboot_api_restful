package com.api.project.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.entity.User;
import com.api.project.repository.UserRepository;

@RestController
public class UserController {

	private final UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@PostMapping("/user")
	User recordUser(@RequestBody User user) {
		User userRecorded = userRepository.save(user);
		return userRecorded;
	}
	
	@DeleteMapping("/user/{id}")
	void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@PutMapping("/user/{id}")
	void updateUser(@RequestBody User user, @PathVariable int id) {
		User userToUpdate = userRepository.getOne(id);
		userToUpdate.setName(user.getName());
		userToUpdate.setPassword(user.getPassword());
		userRepository.save(userToUpdate);
	}
	
	
}
