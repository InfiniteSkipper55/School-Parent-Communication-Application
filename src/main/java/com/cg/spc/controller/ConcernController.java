package com.cg.spc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.Concern;
import com.cg.spc.service.IConcernService;

@RestController
@RequestMapping("/api")
public class ConcernController {
	@Autowired
	private IConcernService concernService;
	
	public ConcernController(IConcernService concernService) {
		super();
		this.concernService = concernService;
	}

	@PostMapping("/concerns")
	public Concern addConcern(@RequestBody Concern concern) {
		return concernService.addConcern(concern);
	}
	
	@PutMapping("/concerns")
	public Concern updateConcern(@RequestBody Concern concern) {
		return concernService.updateConcern(concern);
	}
	
	@GetMapping("/concerns")
	public List<Concern> retrieveAllConcerns(){
		return concernService.retrieveAllConcerns();
	}
	
	@GetMapping("/concernsbyparent/{parentId}")
	public List<Concern> retrieveAllConcernsByParent(@PathVariable int parentId){
		return concernService.retrieveAllConcernsByParent(parentId);
	}
	
	@GetMapping("/unresolvedconcerns")
	public List<Concern> retrieveAllUnResolvedConcerns(){
		return concernService.retrieveAllUnResolvedConcerns();
	}
	
	@GetMapping("/concerns/{parentId}")
	public List<Concern> retrieveAllUnResolvedConcernsByParent(@PathVariable int parentId){
		return concernService.retrieveAllUnResolvedConcernsByParent(parentId);
	}

}
