package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import com.cg.spc.entities.Student;

public interface IStudentService {
	public Student addStudent(Student s);
	public Student updateStudent(Student s);
	public Student deleteStudent(long userId);
	public List<Student> retrieveAllStudents();
	public Optional<Student> retrieveStudentById(long userId);

}
