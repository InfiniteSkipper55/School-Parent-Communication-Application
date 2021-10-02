package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Student;
import com.cg.spc.repository.IStudentRepository;

@Service
public class IStudentServiceImplementation implements IStudentService {
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> optional = studentRepository.findById(student.getUserId());
		if (optional.isPresent()) {
			studentRepository.saveAndFlush(student);
		}
		return student;
	}

	@Override
	public Student deleteStudent(long userId) {
		Optional<Student> existingStudentContainer = studentRepository.findById(userId);
		Student existingStudent = null;
		if (existingStudentContainer.isPresent()) {
			existingStudent = existingStudentContainer.get();
			studentRepository.deleteById(userId);
		}
		return existingStudent;
	}

	@Override
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> retrieveStudentById(long userId) {
		return studentRepository.findById(userId);
	}
	

}
