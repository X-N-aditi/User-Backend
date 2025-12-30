package com.User.Models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "useraddresses")
public class UserAddresses {
	
	@Id
	@Column(name = "address_id")
	private String AddressId = UUID.randomUUID().toString();
	
	@Column(name = "full_address")
	private String FullAddress;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	private UserMaster userMaster;
	
	public String getAddressId() {
		return AddressId;
	}

	public void setAddressId(String addressId) {
		AddressId = addressId;
	}

	public String getFullAddress() {
		return FullAddress;
	}

	public void setFullAddress(String fullAddress) {
		FullAddress = fullAddress;
	}

	public UserMaster getUserMaster() {
		return userMaster;
	}

	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	

}
