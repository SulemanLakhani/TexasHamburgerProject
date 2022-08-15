package com.hamburger.texashamburgercompany.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamburger.texashamburgercompany.model.Users;
import com.hamburger.texashamburgercompany.repository.UsersRepository;
import com.hamburger.texashamburgercompany.service.UserService;

@RestController
//@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UsersRepository repository;

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public Users getUserById(@PathVariable("id") Long id) {

		Users user = userService.getUserById(id);
		return user;
	}

	@PostMapping("/addOrUpdateUser")
	public Users addUser(@RequestBody Users user) {
		return userService.addOrUpdateUser(user);
	}
	
	@DeleteMapping("deleteUser/{id}")
	public Users deleteRestaurantById(@PathVariable("id") Long id) throws Exception {

		Optional<Users> opt = repository.findById(id);

		if (opt.isEmpty()) {
			throw new Exception("Id is not Valid");
		}
		Users user = opt.get();
		repository.delete(user);
		return user;
	}


}
