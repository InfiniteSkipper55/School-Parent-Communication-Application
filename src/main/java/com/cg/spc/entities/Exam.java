package com.cg.spc.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="EXAM_1")
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EXAM_ID")
	private int examId;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name = "DATE_OF_EXAM")
	private Date dateOfExam;
	
	@Column(name = "MAX_MARKS")
	private int maxMarks;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUBJECT")
	private Subject subject;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="EXAM_TYPE")
	private ExamType examType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLASS_ID")
	private ClassId classId;
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public Date getDateOfExam() {
		return dateOfExam;
	}
	public void setDateOfExam(Date dateOfExam) {
		this.dateOfExam = dateOfExam;
	}
	public int getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public ExamType getExamType() {
		return examType;
	}
	public void setExamType(ExamType examType) {
		this.examType = examType;
	}
	public ClassId getClassId() {
		return classId;
	}
	public void setClassId(ClassId classId) {
		this.classId = classId;
	}
	
	public Exam(int examId, Date dateOfExam, int maxMarks, Subject subject, ExamType examType, ClassId classId) {
		super();
		this.examId = examId;
		this.dateOfExam = dateOfExam;
		this.maxMarks = maxMarks;
		this.subject = subject;
		this.examType = examType;
		this.classId = classId;
	}
	public Exam() {
		super();
	}
	
	

}
