package com.cg.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.spc.entities.ClassDiary;

public interface IClassDiaryRepository extends JpaRepository<ClassDiary, Integer> {
	
}
