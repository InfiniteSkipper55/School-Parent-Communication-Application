package com.cg.spc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.Parent;
import com.cg.spc.service.ParentService;

@RestController
@RequestMapping("/api")
public class ParentController {
	@Autowired
	private ParentService parentService;
	
	public ParentController(ParentService parentService) {
		super();
		this.parentService = parentService;
	}

	@PostMapping("/parents")
	public Parent addParent(@RequestBody Parent parent) {
		return parentService.addParent(parent);
	}
	
	@PutMapping("/parents")
	public Parent updateParent(@RequestBody Parent parent) {
		return parentService.updateParent(parent);
	}
	
	@GetMapping("/parents/{classId}")
	public List<Parent> retrieveParentListByClass(@PathVariable long classId){
		return parentService.retrieveParentListByClass(classId);
	}
	
	@GetMapping("/parents/{userId}")
	public List<Parent> retrieveParentByStudent(@PathVariable long userId) {
		return parentService.retrieveParentByStudent(userId);
	}
	
	@GetMapping("/parents/{parentId}")
	public Optional<Parent> retrieveParentById(@PathVariable int parentId) {
		return parentService.retrieveParentById(parentId);
	}

}
