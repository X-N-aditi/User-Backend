package com.User.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.User.Models.UserAddresses;
import com.User.Models.UserMaster;
import com.User.Repository.UserAddressesRepository;
import com.User.Repository.UserMasterRepository;

import com.User.Exception.ResourceNotFoundException;


@Service
public class UserAddressesService {
	
	@Autowired
	private UserAddressesRepository userAddressesRepo;
	
	@Autowired
	private UserMasterRepository userMasterRepo;
	
	public UserAddresses createAddress(String userId, UserAddresses address) {
		UserMaster user = userMasterRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + userId));
		address.setUserMaster(user);
		return userAddressesRepo.save(address);
	}
	
	public List<UserAddresses> getAddressByUserId(String userId) {
		UserMaster user = userMasterRepo.findById(userId).
				orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + userId));
		return user.getAddresses();
	}
	
	public String deleteAddress(String userId, String addressId) {
		UserMaster user = userMasterRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + userId));
		
		UserAddresses address = userAddressesRepo.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("address not found with this id: " + addressId));
		
		if(!address.getUserMaster().getUserId().equals(user.getUserId())) {
			throw new ResourceNotFoundException("address not belong to this user");
		}
		
		userAddressesRepo.delete(address);
		return "Address deleted successfully";
	}
	
	public UserAddresses updateAddress(String userId, String addressId, UserAddresses updateAddress) {
		UserMaster user = userMasterRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with this id: " + userId));
		
		UserAddresses existingAddress = userAddressesRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("address not found with this id: " + addressId));
		
		if(!existingAddress.getUserMaster().getUserId().equals(user.getUserId())) {
			throw new ResourceNotFoundException("address not found with this id");
		}
		
		existingAddress.setFullAddress(updateAddress.getFullAddress());
		return userAddressesRepo.save(existingAddress);
	}
	
	
}
