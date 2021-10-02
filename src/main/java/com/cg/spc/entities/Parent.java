package com.cg.spc.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="PARENT_1")
public class Parent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PARENT_ID")
	private int parentId;
	
	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT")
	private Student student;
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Parent(int parentId, String mobileNumber, String emailId) {
		super();
		this.parentId = parentId;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
	}
	public Parent() {
		super();
	}
	
	

}
