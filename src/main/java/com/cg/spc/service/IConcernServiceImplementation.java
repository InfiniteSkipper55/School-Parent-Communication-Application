package com.cg.spc.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Concern;
import com.cg.spc.entities.Parent;
import com.cg.spc.repository.ConcernRepository;
import com.cg.spc.repository.ParentRepository;

@Service
public class IConcernServiceImplementation implements ConcernService {
	@Autowired
	private ConcernRepository concernRepository;
	
	@Autowired
	private ParentRepository parentRepository;

	@Override
	public Concern addConcern(Concern concern) {
		Parent parent  = concern.getParent();
		if(parent != null) {
			int parentId = parent.getParentId();
			Optional<Parent> parentContainer = parentRepository.findById(parentId);
			if(parentContainer.isPresent()) {
				concern.setParent(parentContainer.get());
			}
		}
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
		List<Concern> concerns = concernRepository.findAll();
		List<Concern> allUnResolvedConcerns = concerns.stream().filter(e -> !e.isResolved())
				.collect(Collectors.toList());
		return allUnResolvedConcerns;
	}

	@Override
	public Concern retrieveAllUnResolvedConcernsByParent(int parentId) {
		Optional<Parent> parent = parentRepository.findById(parentId);
		Concern concerns = null;
		if (parent.isPresent()) {
			concerns = concernRepository.findByParent1(parent.get());
		}
		if (!concerns.isResolved()) {
			return concerns;

		}
		return null;
	}
	
	

}
