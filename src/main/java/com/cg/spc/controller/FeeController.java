package com.cg.spc.controller;

import java.util.Date;
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

import com.cg.spc.entities.Fee;
import com.cg.spc.service.IFeeService;

@RestController
@RequestMapping("/api")
public class FeeController {
	@Autowired
	private IFeeService feeService;
	
	public FeeController(IFeeService feeService) {
		super();
		this.feeService = feeService;
	}

	@PostMapping("/fees")
	public Fee addFee(@RequestBody Fee fee) {
		return feeService.addFee(fee);
	}
	
	@DeleteMapping("/fees/{feeId}")
	public Fee deleteFee(@PathVariable int feeId) {
		return feeService.deleteFee(feeId);
	}
	
	@PutMapping("/fees")
	public Fee updateFee(@RequestBody Fee fee) {
		return feeService.updateFee(fee);
	}
	
	@GetMapping("/fees/{feeId}")
	public Optional<Fee> retrieveFee(@PathVariable int feeId) {
		return feeService.retrieveFee(feeId);
	}
	
	@GetMapping("/fees/{userId}")
	public Fee retrieveFeeByStudent(@PathVariable long userId) {
		return feeService.retrieveFeeByStudent(userId);
	}
	
	@GetMapping("/fees/{startMonthYear}")
	public List<Fee> retrieveAllFeeByMonth(@RequestBody Date startMonthYear){
		return feeService.retrieveAllFeeByMonth(startMonthYear);
	}

}
