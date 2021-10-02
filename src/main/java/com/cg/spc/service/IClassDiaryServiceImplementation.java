package com.cg.spc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.ClassDiary;
import com.cg.spc.repository.IClassDiaryRepository;

@Service
public class IClassDiaryServiceImplementation implements IClassDiaryService {
	@Autowired
	private IClassDiaryRepository classDiaryRepository;

	@Override
	public ClassDiary addClassDiary(ClassDiary classDiary) {
		return classDiaryRepository.save(classDiary);
	}

	@Override
	public Optional<ClassDiary> retrieveClassDiary(int classDiaryId) {
		return classDiaryRepository.findById(classDiaryId);
	}
	

}
