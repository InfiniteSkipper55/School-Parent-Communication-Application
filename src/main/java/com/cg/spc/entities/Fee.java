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

@Entity(name="FEE_1")
public class Fee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FEE_ID")
	private int feeId;
	
	@Column(name = "TOTAL_FEES_DUE")
	private double totalFeesDue;
	
	@Column(name = "TOTAL_FEES_RECEIVED")
	private double totalFeesReceived;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = "STARTING_MONTH")
	private Date startMonthYear;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = "ENDING_MONTH")
	private Date endMonthYear;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT")
	private Student student;
	
	public int getFeeId() {
		return feeId;
	}
	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}
	public double getTotalFeesDue() {
		return totalFeesDue;
	}
	public void setTotalFeesDue(double totalFeesDue) {
		this.totalFeesDue = totalFeesDue;
	}
	public double getTotalFeesReceived() {
		return totalFeesReceived;
	}
	public void setTotalFeesReceived(double totalFeesReceived) {
		this.totalFeesReceived = totalFeesReceived;
	}
	public Date getStartMonthYear() {
		return startMonthYear;
	}
	public void setStartMonthYear(Date startMonthYear) {
		this.startMonthYear = startMonthYear;
	}
	public Date getEndMonthYear() {
		return endMonthYear;
	}
	public void setEndMonthYear(Date endMonthYear) {
		this.endMonthYear = endMonthYear;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Fee(int feeId, double totalFeesDue, double totalFeesReceived, Date startMonthYear, Date endMonthYear,
			Student student) {
		super();
		this.feeId = feeId;
		this.totalFeesDue = totalFeesDue;
		this.totalFeesReceived = totalFeesReceived;
		this.startMonthYear = startMonthYear;
		this.endMonthYear = endMonthYear;
		this.student = student;
	}
	public Fee() {
		super();
	}
	
	

}
