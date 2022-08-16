package com.hamburger.texashamburgercompany.service;

import java.util.List;

import com.hamburger.texashamburgercompany.model.RestaurantLocations;
import com.hamburger.texashamburgercompany.model.Users;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	List<Users> getAllUsers();
	
	Users getUserById(Long id);
	
	Users addOrUpdateUser(Users user);
	
	Users deleteUser(Long id) throws Exception;

	List<Users> getUsersWithSorting(String field);

}
