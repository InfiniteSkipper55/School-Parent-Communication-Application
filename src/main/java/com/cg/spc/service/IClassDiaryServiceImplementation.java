package com.cg.spc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.ClassDiary;
import com.cg.spc.entities.DiaryNotes;
import com.cg.spc.repository.ClassDiaryRepository;
import com.cg.spc.repository.DiaryNotesRepository;

@Service
public class IClassDiaryServiceImplementation implements ClassDiaryService {
	@Autowired
	private ClassDiaryRepository classDiaryRepository;
	
	@Autowired
	private DiaryNotesRepository diaryNotesRepository;

	@Override
	public ClassDiary addClassDiary(ClassDiary classDiary) {
		DiaryNotes diaryNotes  = classDiary.getDiaryNotes();
		if(diaryNotes != null) {
			int diaryNotesId = diaryNotes.getDiaryNotesId();
			Optional<DiaryNotes> diaryNotesContainer = diaryNotesRepository.findById(diaryNotesId);
			if(diaryNotesContainer.isPresent()) {
				classDiary.setDiaryNotes(diaryNotesContainer.get());
			}
		}
		return classDiaryRepository.save(classDiary);
	}

	@Override
	public Optional<ClassDiary> retrieveClassDiary(int classDiaryId) {
		return classDiaryRepository.findById(classDiaryId);
	}
	

}
