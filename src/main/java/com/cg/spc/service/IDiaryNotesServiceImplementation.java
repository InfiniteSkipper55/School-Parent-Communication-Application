package com.cg.spc.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.DiaryNotes;
import com.cg.spc.repository.DiaryNotesRepository;

@Service
public class IDiaryNotesServiceImplementation implements DiaryNotesService {
	@Autowired
	private DiaryNotesRepository diaryNotesRepository;

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
	public List<DiaryNotes> retrieveAllDiaryNotesByDate(Date dateOfDiaryNotes) {
		List<DiaryNotes> existingDiaryNotes = diaryNotesRepository.findByDate(dateOfDiaryNotes);
		Collections.sort(existingDiaryNotes, new Comparator<DiaryNotes>() {
		    public int compare(DiaryNotes m1, DiaryNotes m2) {
		        return m1.getDateOfDiaryNotes().compareTo(m2.getDateOfDiaryNotes());
		    }
		});
		return existingDiaryNotes;
	}

	@Override
	public List<DiaryNotes> retrieveAllDiaryNotesBySubject(int subjectId) {
		return null;
	}
	

}
