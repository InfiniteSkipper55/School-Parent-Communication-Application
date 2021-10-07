package com.cg.spc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="TEACHER_1")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEACHER_ID")
	private int teacherId;
	
	@Column(name = "TEACHER_NAME")
	private String name;
	
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
	public Teacher(int teacherId, String name) {
		super();
		this.teacherId = teacherId;
		this.name = name;
	}
	
	public Teacher() {
		super();
	}	

}
