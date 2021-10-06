package com.cg.spc.service;

import java.util.Optional;

import com.cg.spc.entities.ClassDiary;

public interface ClassDiaryService {
	public ClassDiary addClassDiary(ClassDiary cd);
	public Optional<ClassDiary> retrieveClassDiary(int classDiaryId);

}
