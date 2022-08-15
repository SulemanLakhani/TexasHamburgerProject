package com.hamburger.texashamburgercompany.service;

import java.util.List;

import com.hamburger.texashamburgercompany.model.Users;

public interface UserService {
	
	List<Users> getAllUsers();
	
	Users getUserById(Long id);
	
	Users addOrUpdateUser(Users user);
	
	Users deleteUser(Long id) throws Exception;

}
