package com.cg.spc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="DIARY_NOTES_1")
public class DiaryNotes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DIARY_NOTES_ID")
	private int diaryNotesId;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name = "DATE_OF_DIARY_NOTES")
	private Date dateOfDiaryNotes;
	
	public int getDiaryNotesId() {
		return diaryNotesId;
	}
	public void setDiaryNotesId(int diaryNotesId) {
		this.diaryNotesId = diaryNotesId;
	}
	
	public Date getDateOfDiaryNotes() {
		return dateOfDiaryNotes;
	}
	public void setDateOfDiaryNotes(Date dateOfDiaryNotes) {
		this.dateOfDiaryNotes = dateOfDiaryNotes;
	}	
	public DiaryNotes(int diaryNotesId, Date dateOfDiaryNotes) {
		super();
		this.diaryNotesId = diaryNotesId;
		this.dateOfDiaryNotes = dateOfDiaryNotes;
	}
	public DiaryNotes() {
		super();
	}
	
	

}
