package com.cg.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.spc.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String userName);
	
}
