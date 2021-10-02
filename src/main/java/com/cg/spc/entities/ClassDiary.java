package com.cg.spc.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="CLASS_DIARY")
public class ClassDiary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLASS_DIARY_ID")
	private int classDiaryId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DIARY_NOTES")
	private DiaryNotes diaryNotes;
	
	public int getClassDiaryId() {
		return classDiaryId;
	}

	public void setClassDiaryId(int classDiaryId) {
		this.classDiaryId = classDiaryId;
	}

	public ClassDiary(int classDiaryId) {
		super();
		this.classDiaryId = classDiaryId;
	}

	public ClassDiary() {
		super();
	}
	
	

}
