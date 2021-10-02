package com.cg.spc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.DiaryNotes;
import com.cg.spc.service.IDiaryNotesService;

@RestController
@RequestMapping("/api")
public class DiaryNotesController {
	@Autowired
	private IDiaryNotesService diaryNotesService;
	
	public DiaryNotesController(IDiaryNotesService diaryNotesService) {
		super();
		this.diaryNotesService = diaryNotesService;
	}

	@PostMapping("/diarynotes")
	public DiaryNotes addDiaryNotes(@RequestBody DiaryNotes diaryNotes) {
		return diaryNotesService.addDiaryNotes(diaryNotes);
	}
	
	@PutMapping("/diarynotes")
	public DiaryNotes updateDiaryNotes(@RequestBody DiaryNotes diaryNotes) {
		return diaryNotesService.updateDiaryNotes(diaryNotes);
	}
	
	@DeleteMapping("/diarynotes/{diaryNotesId}")
	public DiaryNotes deleteDiaryNotes(@PathVariable int diaryNotesId) {
		return diaryNotesService.deleteDiaryNotes(diaryNotesId);
	}
	
	@GetMapping("/diarynotes")
	public List<DiaryNotes> retrieveAllDiaryNotesByDate(@RequestBody Date date){
		return diaryNotesService.retrieveAllDiaryNotesByDate(date);
	}
	
	@GetMapping("/diarynotes/{subjectId}")
	public List<DiaryNotes> retrieveAllDiaryNotesBySubject(@PathVariable int subjectId){
		return diaryNotesService.retrieveAllDiaryNotesBySubject(subjectId);
	}

}
