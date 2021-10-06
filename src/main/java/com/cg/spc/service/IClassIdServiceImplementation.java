package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.ClassId;
import com.cg.spc.repository.ClassIdRepository;
import com.cg.spc.repository.StudentRepository;

@Service
public class IClassIdServiceImplementation implements ClassIdService {
	@Autowired
	ClassIdRepository classIdRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public ClassId addClass(ClassId classId) {
		return classIdRepository.save(classId);
	}

	@Override
	public ClassId updateClass(ClassId classId) {
		Optional<ClassId> existingClassIdContainer = classIdRepository.findById(classId.getClassId());
		if (existingClassIdContainer.isPresent()) {
			classIdRepository.saveAndFlush(classId);
		}
		return classId;
	}

	@Override
	public ClassId deleteClassById(long classId) {
		Optional<ClassId> existingClassIdContainer = classIdRepository.findById(classId);
		ClassId existingClassId = null;
		if (existingClassIdContainer.isPresent()) {
			existingClassId = existingClassIdContainer.get();
			classIdRepository.deleteById(classId);
		}
		return existingClassId;
	}

	@Override
	public List<ClassId> retrieveAllClassId() {
		return classIdRepository.findAll();
	}

	@Override
	public Optional<ClassId> retrieveClassIdById(long classId) {
		return classIdRepository.findById(classId);
	}

}
