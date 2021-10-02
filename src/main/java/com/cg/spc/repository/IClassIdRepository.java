package com.cg.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spc.entities.ClassId;

public interface IClassIdRepository extends JpaRepository<ClassId, String> {

}
