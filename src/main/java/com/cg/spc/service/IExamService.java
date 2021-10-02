package com.cg.spc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cg.spc.entities.Exam;

public interface IExamService {
	public Exam addExam(Exam e);
	public Exam deleteExam(int i);
	public Exam updateExam(Exam e);
	public List<Exam> listAllExamsByDate(Date dateOfExam);
	public List<Exam> listAllExamsByClass(String classId);
	public List<Exam> listAllExamsByStudent(long userId);
	public Optional<Exam> listExamById(int examId);

}
