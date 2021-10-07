package com.cg.spc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CLASS_ID_1")
public class ClassId {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLASS_ID")
	private long classId;
	
	@Column(name = "GRADE")
	private int grade;
	
	@Column(name = "DIVISION")
	private char division;
	
	public long getClassId() {
		return classId;
	}
	public void setClassId(long classId) {
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
	public ClassId(long classId, int grade, char division) {
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
