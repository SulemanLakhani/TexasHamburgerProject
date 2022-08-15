package com.hamburger.texashamburgercompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hamburger.texashamburgercompany.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	
}
