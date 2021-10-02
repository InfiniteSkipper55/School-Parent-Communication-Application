package com.cg.spc.entities;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="TEACHER_1")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEACHER_ID")
	private int teacherId;
	
	@Column(name = "TEACHER_NAME")
	private String name;
	
	@ElementCollection
	@ManyToOne(targetEntity = ClassId.class)
	@JoinColumn(name = "SUBJECT_CLASSES")
	private Map<Subject, List<ClassId>> subjectClasses;
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Subject, List<ClassId>> getSubjectClasses() {
		return subjectClasses;
	}
	public void setSubjectClasses(Map<Subject, List<ClassId>> subjectClasses) {
		this.subjectClasses = subjectClasses;
	}
	public Teacher(int teacherId, String name, Map<Subject, List<ClassId>> subjectClasses) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.subjectClasses = subjectClasses;
	}
	
	public Teacher() {
		super();
	}	

}
