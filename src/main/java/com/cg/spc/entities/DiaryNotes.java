package com.cg.spc.entities;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="DIARY_NOTES_1")
public class DiaryNotes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DIARY_NOTES_ID")
	private int diaryNotesId;
	
	@ElementCollection
	@Column(name = "NOTES")
	private Map<Subject, String> notes;
	
	public int getDiaryNotesId() {
		return diaryNotesId;
	}
	public void setDiaryNotesId(int diaryNotesId) {
		this.diaryNotesId = diaryNotesId;
	}
	public Map<Subject, String> getNotes() {
		return notes;
	}
	public void setNotes(Map<Subject, String> notes) {
		this.notes = notes;
	}
	public DiaryNotes(int diaryNotesId, Map<Subject, String> notes) {
		super();
		this.diaryNotesId = diaryNotesId;
		this.notes = notes;
	}
	
	public DiaryNotes() {
		super();
	}
	
	

}
