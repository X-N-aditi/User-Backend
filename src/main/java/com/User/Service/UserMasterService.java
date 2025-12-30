package com.User.Service;

import com.User.Models.UserMaster;
import com.User.Repository.UserMasterRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.User.Exception.ResourceNotFoundException;

@Service
public class UserMasterService {
	
	@Autowired
	private UserMasterRepository userMasterRepo;
	
	public String createUser(UserMaster user) {
		userMasterRepo.save(user);
		return "User created successfully";
	}
	
	public UserMaster getUserById(String id) {
		return userMasterRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with the id: " + id));
	}
	
	public List<UserMaster> getAllUsers() {
		return userMasterRepo.findAll();
	}
	
	public String deleteUserById(String id) {
		userMasterRepo.delete(getUserById(id));
		return "User deleted successfully";
	}
	
	public UserMaster updateUserById(String id, UserMaster updateUser) {
		UserMaster existing = getUserById(id);
		
		existing.setUserName(updateUser.getUserName());
		existing.setUserPassword(updateUser.getUserPassword());
		existing.setUserPhoneNo(updateUser.getUserPhoneNo());
		existing.setUserStatus(updateUser.getUserStatus());
		
		return userMasterRepo.save(existing);
	}

}
