package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Concern;
import com.cg.spc.entities.Parent;
import com.cg.spc.repository.IConcernRepository;
import com.cg.spc.repository.IParentRepository;

@Service
public class IConcernServiceImplementation implements IConcernService {
	@Autowired
	private IConcernRepository concernRepository;
	
	@Autowired
	private IParentRepository parentRepository;

	@Override
	public Concern addConcern(Concern concern) {
		return concernRepository.save(concern);
	}

	@Override
	public Concern updateConcern(Concern concern) {
		int concernId = concern.getConcernId();
		Optional<Concern> existingConcernContainer = concernRepository.findById(concernId);
		Concern existingConcern = null;
		if(existingConcernContainer.isPresent()) {
			existingConcern = existingConcernContainer.get();
			existingConcern.setConcernDescription(concern.getConcernDescription());
			existingConcern.setResolved(concern.isResolved());
			concernRepository.saveAndFlush(existingConcern);
		}
		return existingConcern;
	}

	@Override
	public List<Concern> retrieveAllConcerns() {
		return concernRepository.findAll();
	}

	@Override
	public List<Concern> retrieveAllConcernsByParent(int parentId) {
		Optional<Parent> parent = parentRepository.findById(parentId);
		if(parent.isPresent()) {
			return concernRepository.findByParent(parent.get());	
		}
		return null;
	}

	@Override
	public List<Concern> retrieveAllUnResolvedConcerns() {
		return null;
	}

	@Override
	public List<Concern> retrieveAllUnResolvedConcernsByParent(int parentId) {
		return null;
	}
	

}
