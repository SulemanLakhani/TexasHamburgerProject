package com.hamburger.texashamburgercompany.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamburger.texashamburgercompany.model.Users;
import com.hamburger.texashamburgercompany.service.UserService;

@RestController
//@RequestMapping("/api")
public class UserController {
	Logger logger = LoggerFactory.getLogger(RestaurantController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public Users getUserById(@PathVariable("id") Long id) {

		Users user = null;
		try {
			user = userService.getUserById(id);
		} catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}

		logger.error("User Id: " + user);
		return user;
	}

	@GetMapping("/usersWithSorting/{field}")
	public List<Users> usersWithSorting(@PathVariable("field") String field){

		List<Users> users = null;
		try{
			users = userService.getUsersWithSorting(field);
		} catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		logger.error("API called with response: " + users);

		return users;
	}
	@PostMapping("/addOrUpdateUser")
	public Users addUser(@RequestBody Users user) {
		Users users = null;
		try {
			users = userService.addOrUpdateUser(user);
		} catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}

		logger.error("User Added and updated: " + users);
		return users;
	}
	
	@DeleteMapping("deleteUser/{id}")
	public Users deleteRestaurantById(@PathVariable("id") Long id) throws Exception {

		Users users = null;
		try {
			users = userService.deleteUser(id);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		logger.error("User deleted: " + users);
		return users;
	}
}
