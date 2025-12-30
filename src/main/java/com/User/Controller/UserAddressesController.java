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

import com.User.Models.UserAddresses;
import com.User.Service.UserAddressesService;

@RestController
@RequestMapping("/addresses")
@CrossOrigin(origins="*")
public class UserAddressesController {
	
	@Autowired
	private UserAddressesService userAddressesService;
	
	@PostMapping("/{userId}")
	public ResponseEntity<UserAddresses> createAddress(@PathVariable String userId, @RequestBody UserAddresses address) {
		UserAddresses createdAddress = userAddressesService.createAddress(userId, address);
		return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<UserAddresses>> getAddressByUserId(@PathVariable String userId) {
		List<UserAddresses> address = userAddressesService.getAddressByUserId(userId);
		return ResponseEntity.ok(address);
	}
	
	@PutMapping("/{userId}/{addressId}")
	public ResponseEntity<UserAddresses> updateAddress(@PathVariable String userId, @PathVariable String addressId,  @RequestBody UserAddresses address) {
		UserAddresses updatedAddress = userAddressesService.updateAddress(userId, addressId, address);
		return ResponseEntity.ok(updatedAddress);
	}
	
	@DeleteMapping("/{userId}/{addressId}")
	public ResponseEntity<String> deleteAddress(@PathVariable String userId, @PathVariable String addressId) {
		String message = userAddressesService.deleteAddress(userId, addressId);
		return ResponseEntity.ok(message);
	}

}
