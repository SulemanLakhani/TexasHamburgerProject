package com.hamburger.texashamburgercompany.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hamburger.texashamburgercompany.model.Users;
import com.hamburger.texashamburgercompany.repository.UsersRepository;
import com.hamburger.texashamburgercompany.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public Users getUserById(Long id) {
		
		Optional<Users> opt = usersRepository.findById(id);

		if (opt.isEmpty()) {
			throw new RuntimeException("Id is not Valid");
		}
		Users users = opt.get();

		return users;
	}

	@Override
	public Users addOrUpdateUser(Users user) {
		Users users = null;
		try {
			users = usersRepository.save(user);
		} catch (Exception e) {
			e.getMessage();
		}
		
		System.out.println(users);
		return user;
	}

	@Override
	public Users deleteUser(Long id) throws Exception {
		Users deletedUsers = null;
		try {
			deletedUsers = usersRepository.findById(id).orElse(null);

			if (deletedUsers == null) {
				throw new Exception("users not available");
			} else {
				usersRepository.deleteById(id);
			}
		} catch (Exception e) {
			throw e;
		}
		return deletedUsers;
	}

	@Override
	public List<Users> getUsersWithSorting(String field) {
		return usersRepository.findAll(Sort.by(Sort.Direction.ASC,field));
	}

}
