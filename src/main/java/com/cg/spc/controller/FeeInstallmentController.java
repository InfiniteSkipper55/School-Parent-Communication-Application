package com.cg.spc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.FeeInstallment;
import com.cg.spc.service.FeeInstallmentService;

@RestController
@RequestMapping("/api")
public class FeeInstallmentController {
	@Autowired
	private FeeInstallmentService feeInstallmentService;
	
	public FeeInstallmentController(FeeInstallmentService feeInstallmentService) {
		super();
		this.feeInstallmentService = feeInstallmentService;
	}

	@PostMapping("/feeinstallments")
	public FeeInstallment makePayment(@RequestBody FeeInstallment feeInstallment) {
		return feeInstallmentService.makePayment(feeInstallment);
	}
	
	@GetMapping("/feeinstallments/{userId}")
	public List<FeeInstallment> pendingInstallments(@PathVariable long userId){
		return feeInstallmentService.pendingInstallments(userId);
	}
	
	@GetMapping("/feeinstallmentsbyid/{feeInstallmentId}")
	public Optional<FeeInstallment> retrieveFeeInstallmentById(@PathVariable int feeInstallmentId) {
		return feeInstallmentService.retrieveFeeInstallmentById(feeInstallmentId);
	}
	
	@GetMapping("/feeinstallments/{feeId}")
	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(@PathVariable int feeId){
		return feeInstallmentService.retrieveAllFeeInstallmentsByFee(feeId);
	}

}
