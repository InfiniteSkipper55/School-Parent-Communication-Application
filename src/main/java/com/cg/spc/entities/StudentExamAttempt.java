package com.cg.spc.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="STUDENT_EXAM_ATTEMPT_1")
public class StudentExamAttempt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_EXAM_ATTEMPT_ID")
	private int studentExamAttemptId;
	
	@Column(name = "ATTEMPTED")
	private boolean attempted;
	
	@Column(name = "MARKS_OBTAINED")
	private int marksObtained;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EXAM")
	private Exam exam;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT")
	private Student student;
	
	public int getStudentExamAttemptId() {
		return studentExamAttemptId;
	}
	public void setStudentExamAttemptId(int studentExamAttemptId) {
		this.studentExamAttemptId = studentExamAttemptId;
	}
	public boolean isAttempted() {
		return attempted;
	}
	public void setAttempted(boolean attempted) {
		this.attempted = attempted;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public StudentExamAttempt(int studentExamAttemptId, boolean attempted, int marksObtained) {
		super();
		this.studentExamAttemptId = studentExamAttemptId;
		this.attempted = attempted;
		this.marksObtained = marksObtained;
	}
	public StudentExamAttempt() {
		super();
	}
	
	

}
