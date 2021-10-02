package com.cg.spc.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "ATTENDANCE")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ATTENDANCE_ID")
	private int attendanceId;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = "DATE_OF_CLASS")
	private Date dateOfClass;
	
	@Column(name = "PRESENT")
	private boolean present;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT")
	private Student student;
	
	public int getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}
	public Date getDateOfClass() {
		return dateOfClass;
	}
	public void setDateOfClass(Date dateOfClass) {
		this.dateOfClass = dateOfClass;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	public Attendance(int attendanceId, Date dateOfClass, boolean present) {
		super();
		this.attendanceId = attendanceId;
		this.dateOfClass = dateOfClass;
		this.present = present;
	}
	public Attendance() {
		super();
	}
	
	

}
