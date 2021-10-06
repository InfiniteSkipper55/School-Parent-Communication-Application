package com.cg.spc.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.DiaryNotes;

public interface DiaryNotesRepository extends JpaRepository<DiaryNotes, Integer> {

	@Query(value = "SELECT * FROM DIARY_NOTES_1 WHERE DATE_OF_DIARY_NOTES = ?1", nativeQuery =true)
	List<DiaryNotes> findByDate(Date dateOfDiaryNotes);

	
}
