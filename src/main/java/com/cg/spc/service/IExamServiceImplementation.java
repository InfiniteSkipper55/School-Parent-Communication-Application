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
import com.cg.spc.repository.ClassIdRepository;
import com.cg.spc.repository.ExamRepository;

@Service
public class IExamServiceImplementation implements ExamService {
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private ClassIdRepository classIdRepository;
	

	@Override
	public Exam addExam(Exam exam) {
		ClassId classId  = exam.getClassId();
		if(classId != null) {
			long id = classId.getClassId();
			Optional<ClassId> classIdContainer = classIdRepository.findById(id);
			if(classIdContainer.isPresent()) {
				exam.setClassId(classIdContainer.get());
			}
		}
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
		List<Exam> existingExam = examRepository.findByDate(dateOfExam);
		Collections.sort(existingExam, new Comparator<Exam>() {
		    public int compare(Exam m1, Exam m2) {
		        return m1.getDateOfExam().compareTo(m2.getDateOfExam());
		    }
		});
		return existingExam;
	}

	@Override
	public List<Exam> listAllExamsByClass(long classId) {
		Optional<ClassId> class_= classIdRepository.findById(classId);
		if (class_.isPresent()) {
			return examRepository.findByClassId(class_.get());
		}
		return null;
	}

	@Override
	public Optional<Exam> listExamById(int examId) {
		return examRepository.findById(examId);
	}
	

}
