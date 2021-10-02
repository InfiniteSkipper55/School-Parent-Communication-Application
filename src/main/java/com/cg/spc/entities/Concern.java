package com.cg.spc.entities;

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

@Entity(name="CONCERN_1")
public class Concern {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int concernId;
	
	private String concernDescription;
	private boolean resolved;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="CONCERN_TYPE")
	private ConcernType concernType;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="CONCERN_PARTY")
	private ConcernParty concernParty;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PARENT")
	private Parent parent;
	
	public int getConcernId() {
		return concernId;
	}
	public void setConcernId(int concernId) {
		this.concernId = concernId;
	}
	public String getConcernDescription() {
		return concernDescription;
	}
	public void setConcernDescription(String concernDescription) {
		this.concernDescription = concernDescription;
	}
	public boolean isResolved() {
		return resolved;
	}
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	public Concern(int concernId, String concernDescription, boolean resolved) {
		super();
		this.concernId = concernId;
		this.concernDescription = concernDescription;
		this.resolved = resolved;
	}
	public Concern() {
		super();
	}
	
	

}
