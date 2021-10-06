package com.cg.spc.service;

import com.cg.spc.entities.User;

public interface UserService {
	public User addNewUser(User u);
	public User signIn(User u);
	public User signOut(User u);

}
