package com.project.questapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp.entities.User;
import com.project.questapp.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userServis;
	
	public UserController(UserService userServis) {
		this.userServis = userServis;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userServis.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userServis.saveOneUser(newUser);
	}
	
	@GetMapping("/userId")
	public User updateOneUser(@PathVariable Long userId) {
		//custom exeption
		return userServis.getOneUser(userId);
	}
	//Gerekli değil
	@PutMapping("/userId")
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		return userServis.updateOneUser(userId, newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {
		userServis.deleteById(userId);
	}
}
