package com.hamburger.texashamburgercompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hamburger.texashamburgercompany.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
}
