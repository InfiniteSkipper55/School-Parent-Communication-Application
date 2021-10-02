package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Parent;
import com.cg.spc.repository.IParentRepository;

@Service
public class IParentServiceImplementation implements IParentService {
	@Autowired
	IParentRepository parentRepository;

	@Override
	public Parent addParent(Parent parent) {
		return parentRepository.save(parent);
	}

	@Override
	public Parent updateParent(Parent parent) {
		Optional<Parent> existingParentContainer = parentRepository.findById(parent.getParentId());
		if (existingParentContainer.isPresent()) {
			parentRepository.saveAndFlush(parent);
		}
		return parent;
	}

	@Override
	public List<Parent> retrieveParentListByClass(String classId) {
		return null;
	}

	@Override
	public Parent retrieveParentByStudent(long userId) {
		return null;
	}

	@Override
	public Parent retrieveParentById(int parentId) {
		return null;
	}
	

}
