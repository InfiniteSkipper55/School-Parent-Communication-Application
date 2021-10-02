package com.cg.spc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.ClassDiary;
import com.cg.spc.service.IClassDiaryService;

@RestController
@RequestMapping("/api")
public class ClassDiaryController {
	@Autowired
	private IClassDiaryService classDiaryService;
	
	public ClassDiaryController(IClassDiaryService classDiaryService) {
		super();
		this.classDiaryService = classDiaryService;
	}

	@PostMapping("/classdiaries")
	public ClassDiary addClassDiary(@RequestBody ClassDiary classDiary) {
		return classDiaryService.addClassDiary(classDiary);
	}
	
	@PostMapping("/classdiaries/{classDiaryId}")
	public Optional<ClassDiary> retrieveClassDiary(@PathVariable int classDiaryId) {
		return classDiaryService.retrieveClassDiary(classDiaryId);
	}

}
