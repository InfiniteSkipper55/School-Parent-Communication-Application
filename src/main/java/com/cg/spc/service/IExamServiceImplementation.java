package com.cg.spc.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.ClassId;
import com.cg.spc.entities.Exam;
import com.cg.spc.repository.IClassIdRepository;
import com.cg.spc.repository.IExamRepository;

@Service
public class IExamServiceImplementation implements IExamService {
	@Autowired
	private IExamRepository examRepository;
	
	@Autowired
	private IClassIdRepository classIdRepository;

	@Override
	public Exam addExam(Exam exam) {
		return examRepository.save(exam);
	}

	@Override
	public Exam deleteExam(int examId) {
		Optional<Exam> existingExamContainer = examRepository.findById(examId);
		Exam existingExam = null;
		if (existingExamContainer.isPresent()) {
			existingExam = existingExamContainer.get();
			examRepository.deleteById(examId);
		}
		return existingExam;
	}

	@Override
	public Exam updateExam(Exam exam) {
		Optional<Exam> optional = examRepository.findById(exam.getExamId());
		if (optional.isPresent()) {
			examRepository.saveAndFlush(exam);
		}
		return exam;
	}

	@Override
	public List<Exam> listAllExamsByDate(Date dateOfExam) {
		List<Exam> existingExam = null;
		Collections.sort(existingExam, new Comparator<Exam>() {
		    public int compare(Exam m1, Exam m2) {
		        return m1.getDateTimeofExam().compareTo(m2.getDateTimeofExam());
		    }
		});
		return existingExam;
	}

	@Override
	public List<Exam> listAllExamsByClass(String classId) {
		Optional<ClassId> class_= classIdRepository.findById((String) classId);
		if (class_.isPresent()) {
			return examRepository.findByClassId(class_.get());
			
		}
		return null;
	}

	@Override
	public List<Exam> listAllExamsByStudent(long userId) {
		return null;
	}

	@Override
	public Optional<Exam> listExamById(int examId) {
		return examRepository.findById(examId);
	}
	

}
