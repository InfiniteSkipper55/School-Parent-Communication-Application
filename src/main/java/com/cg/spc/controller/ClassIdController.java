package com.cg.spc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.ClassId;
import com.cg.spc.service.ClassIdService;

@RestController
@RequestMapping("/api")
public class ClassIdController {
	@Autowired
	private ClassIdService classIdService;

	public ClassIdController(ClassIdService classIdService) {
		super();
		this.classIdService = classIdService;
	}
	
	@PostMapping("/classid")
	public ClassId addClass(@RequestBody ClassId classId) {
		return classIdService.addClass(classId);
	}
	
	@PutMapping("/classid")
	public ClassId updateClass(@RequestBody ClassId classId) {
		return classIdService.updateClass(classId);
	}
	
	@DeleteMapping("/classid/{classId}")
	public ClassId deleteClassById(@PathVariable long classId){
		return classIdService.deleteClassById(classId);
	}
	
	@GetMapping("/classid")
	public List<ClassId> retrieveAllClassId(){
		return classIdService.retrieveAllClassId();
	}
	
	@GetMapping("/classid/{classId}")
	public Optional<ClassId> retrieveClassIdById(@PathVariable long classId){
		return classIdService.retrieveClassIdById(classId);
	}
}
