package com.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.User.Models.UserMaster;
import com.User.Service.UserMasterService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
public class UserMasterController {
	
	@Autowired
	private UserMasterService userMasterService;
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserMaster user){
		String response = userMasterService.createUser(user);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserMaster>> getAllUsers() {
		List<UserMaster> users = userMasterService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserMaster> getUserById(@PathVariable String id) {
		UserMaster user = userMasterService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserMaster> updateUserById(@PathVariable String id, @RequestBody UserMaster user){
		UserMaster updatedUser = userMasterService.updateUserById(id, user);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable String id) {
		String message = userMasterService.deleteUserById(id);
		return ResponseEntity.ok(message);
	}

}
