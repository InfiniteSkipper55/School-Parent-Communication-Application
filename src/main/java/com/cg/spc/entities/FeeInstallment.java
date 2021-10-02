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

@Entity(name="FEE_INSTALLMENT_1")
public class FeeInstallment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FEE_INSTALLMENT_ID")
	private int feeInstallmentId;
	
	@Column(name = "FEE_INSTALLMENT")
	private double feeInstallment;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = "DUE_DATE")
	private Date dueDate;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = "FEE_PAYMENT_DATE")
	private Date feePaymentDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FEE_COLUMN")
	private Fee fee;
	
	public int getFeeInstallmentId() {
		return feeInstallmentId;
	}
	public void setFeeInstallmentId(int feeInstallmentId) {
		this.feeInstallmentId = feeInstallmentId;
	}
	public double getFeeInstallment() {
		return feeInstallment;
	}
	public void setFeeInstallment(double feeInstallment) {
		this.feeInstallment = feeInstallment;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getFeePaymentDate() {
		return feePaymentDate;
	}
	public void setFeePaymentDate(Date feePaymentDate) {
		this.feePaymentDate = feePaymentDate;
	}
	public FeeInstallment(int feeInstallmentId, double feeInstallment, Date dueDate, Date feePaymentDate) {
		super();
		this.feeInstallmentId = feeInstallmentId;
		this.feeInstallment = feeInstallment;
		this.dueDate = dueDate;
		this.feePaymentDate = feePaymentDate;
	}
	public FeeInstallment() {
		super();
	}
	
	

}
