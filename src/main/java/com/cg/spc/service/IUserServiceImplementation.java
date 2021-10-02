package com.cg.spc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.User;
import com.cg.spc.repository.IUserRepository;
@Service
public class IUserServiceImplementation implements IUserService {
	@Autowired
	IUserRepository userRepository;

	@Override
	public User addNewUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User signIn(User user) {
		User userNow = userRepository.findByUserName(user.getUserName());

		if (user.getPassword().equals(userNow.getPassword())) {
			return userNow;
		}
		
		return null;
	}

	@Override
	public User signOut(User user) {
		User userNow = userRepository.findByUserName(user.getUserName());

		if (user.getPassword().equals(userNow.getPassword())) {
			return userNow;
		}
		return null;
	}
	

}
