package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.ClassId;
import com.cg.spc.entities.Parent;
import com.cg.spc.entities.Student;
import com.cg.spc.repository.ClassIdRepository;
import com.cg.spc.repository.ParentRepository;
import com.cg.spc.repository.StudentRepository;

@Service
public class IParentServiceImplementation implements ParentService {
	@Autowired
	ParentRepository parentRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ClassIdRepository classIdRepository;

	@Override
	public Parent addParent(Parent parent) {
		Student student  = parent.getStudent();
		if(student != null) {
			long studentId = student.getUserId();
			Optional<Student> studentContainer = studentRepository.findById(studentId);
			if(studentContainer.isPresent()) {
				parent.setStudent(studentContainer.get());
			}
		}
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
	public List<Parent> retrieveParentListByClass(long classId) {
		Optional<ClassId> id = classIdRepository.findById(classId);
		if (id.isPresent()) {
			Student student = studentRepository.findByStudent(id.get());
			if(student!=null) {
				return parentRepository.findByFee(student);
			}
		}
		return null;
	}

	@Override
	public List<Parent> retrieveParentByStudent(long userId) {
		Optional<Student> student = studentRepository.findById(userId);
		if(student.isPresent()) {			
			return parentRepository.findByFee(student.get());
		}
		return null;
	}

	@Override
	public Optional<Parent> retrieveParentById(int parentId) {
		return parentRepository.findById(parentId);
	}
	

}
