package com.cg.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.spc.entities.ClassDiary;

public interface ClassDiaryRepository extends JpaRepository<ClassDiary, Integer> {
	
}
