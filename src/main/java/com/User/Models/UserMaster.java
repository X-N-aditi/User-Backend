package com.User.Models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "usermaster")
public class UserMaster {
	
	@Id
	@Column(name = "user_id")
	private String userId = UUID.randomUUID().toString();
		
	@Column(name = "user_name")
	private String userName;
		
	@Column(name = "user_password")
	private String userPassword;
		
	@Column(name = "user_phone_no")
	private String userPhoneNo;
		
	@Column(name = "user_date_of_registration")
	private LocalDate userDateOfRegistration;
		
	@Column(name = "user_status")
	private String userStatus;
	
	@OneToMany(mappedBy= "userMaster", cascade= CascadeType.ALL)
	@JsonIgnore
	private List<UserAddresses> addresses;
	
	public List<UserAddresses> getAddresses() {
		return addresses;
	}
		
	public void setAddresses(List<UserAddresses> addresses) {
		this.addresses = addresses;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public LocalDate getUserDateOfRegistration() {
		return userDateOfRegistration;
	}

	@PrePersist
	public void setUserDateOfRegistration() {
		this.userDateOfRegistration = LocalDate.now();
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
		


}
