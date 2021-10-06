package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.spc.entities.ClassId;
@Service
public interface ClassIdService {
	public ClassId addClass(ClassId classId);
	public ClassId updateClass(ClassId classId);
	public ClassId deleteClassById(long classId);
	public List<ClassId> retrieveAllClassId();
	public Optional<ClassId> retrieveClassIdById(long classId);

}
