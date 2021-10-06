package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import com.cg.spc.entities.Parent;


public interface ParentService {
	public Parent addParent(Parent parent);
	public Parent updateParent(Parent parent);
	public List<Parent> retrieveParentByStudent(long userId);
	public Optional<Parent> retrieveParentById(int parentId);
	public List<Parent> retrieveParentListByClass(long classId);

}
