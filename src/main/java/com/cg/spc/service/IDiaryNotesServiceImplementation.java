package com.cg.spc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.DiaryNotes;
import com.cg.spc.repository.IDiaryNotesRepository;

@Service
public class IDiaryNotesServiceImplementation implements IDiaryNotesService {
	@Autowired
	private IDiaryNotesRepository diaryNotesRepository;

	@Override
	public DiaryNotes addDiaryNotes(DiaryNotes diaryNotes) {
		return diaryNotesRepository.save(diaryNotes);
	}

	@Override
	public DiaryNotes updateDiaryNotes(DiaryNotes diaryNotes) {
		Optional<DiaryNotes> optional = diaryNotesRepository.findById(diaryNotes.getDiaryNotesId());
		if (optional.isPresent()) {
			diaryNotesRepository.saveAndFlush(diaryNotes);
		}
		return diaryNotes;
	}

	@Override
	public DiaryNotes deleteDiaryNotes(int diaryNotesId) {
		Optional<DiaryNotes> existingDiaryNotesContainer = diaryNotesRepository.findById(diaryNotesId);
		DiaryNotes existingDiaryNotes = null;
		if (existingDiaryNotesContainer.isPresent()) {
			existingDiaryNotes = existingDiaryNotesContainer.get();
			diaryNotesRepository.deleteById(diaryNotesId);
		}
		return existingDiaryNotes;
	}

	@Override
	public List<DiaryNotes> retrieveAllDiaryNotesByDate(Date date) {
		return null;
	}

	@Override
	public List<DiaryNotes> retrieveAllDiaryNotesBySubject(int subjectId) {
//		Optional<DiaryNotes> diaryNotes = diaryNotesRepository.findById(subjectId);
//		if (diaryNotes.isPresent()) {
//			return diaryNotesRepository.findBySubject(diaryNotes.get());
//		}
		return null;
	}
	

}
