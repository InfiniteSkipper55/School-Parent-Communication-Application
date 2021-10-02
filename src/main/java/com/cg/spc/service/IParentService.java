package com.cg.spc.service;

import java.util.List;

import com.cg.spc.entities.Parent;


public interface IParentService {
	public Parent addParent(Parent parent);
	public Parent updateParent(Parent parent);
	public List<Parent> retrieveParentListByClass(String classId);
	public Parent retrieveParentByStudent(long userId);
	public Parent retrieveParentById(int parentId);

}
