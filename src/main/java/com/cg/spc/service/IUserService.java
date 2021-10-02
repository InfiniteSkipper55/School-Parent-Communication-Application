package com.cg.spc.service;

import com.cg.spc.entities.User;

public interface IUserService {
	public User addNewUser(User u);
	public User signIn(User u);
	public User signOut(User u);

}
