package com.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.User.Models.UserAddresses;

public interface UserAddressesRepository extends JpaRepository<UserAddresses, String>{
	

}
