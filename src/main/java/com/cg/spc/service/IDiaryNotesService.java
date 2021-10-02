package com.cg.spc.service;

import java.util.Date;
import java.util.List;

import com.cg.spc.entities.DiaryNotes;

public interface IDiaryNotesService {
	public DiaryNotes addDiaryNotes(DiaryNotes dn);
	public DiaryNotes updateDiaryNotes(DiaryNotes dn);
	public DiaryNotes deleteDiaryNotes(int diaryNotesId);
	public List<DiaryNotes> retrieveAllDiaryNotesByDate(Date date);
	public List<DiaryNotes> retrieveAllDiaryNotesBySubject(int subjectId);

}
