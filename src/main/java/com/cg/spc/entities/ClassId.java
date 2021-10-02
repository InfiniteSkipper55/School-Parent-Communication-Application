package com.cg.spc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "CLASS_ID_1")
public class ClassId {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLASS_ID")
	private String classId;
	
	@Column(name = "GRADE")
	private int grade;
	
	@Column(name = "DIVISION")
	private char division;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLASS_TEACHERS")
	private Teacher classTeachers;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUBJECT_TEACHERS")
	private List<Teacher> subjectTeachers;
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public char getDivision() {
		return division;
	}
	public void setDivision(char division) {
		this.division = division;
	}
	public ClassId(String classId, int grade, char division) {
		super();
		this.classId = classId;
		this.grade = grade;
		this.division = division;
	}
	public ClassId(int grade, char division) {
		super();
		this.grade = grade;
		this.division = division;
	}
	@Override
	public String toString() {
		return "ClassId [classId=" + classId + ", grade=" + grade + ", division=" + division + "]";
	}
	
	public static void main(String[] args) {
		
	}
	public ClassId() {
		super();
	}
	

}
