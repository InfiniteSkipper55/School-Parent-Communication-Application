package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Fee;
import com.cg.spc.entities.FeeInstallment;
import com.cg.spc.repository.IFeeInstallmentRepository;
import com.cg.spc.repository.IFeeRepository;

@Service
public class IFeeInstallmentServiceImplementation implements IFeeInstallmentService {
	@Autowired
	private IFeeInstallmentRepository feeInstallmentRepository;
	
	@Autowired
	private IFeeRepository feeRepository;

	@Override
	public FeeInstallment makePayment(FeeInstallment feeInstallment) {
		return feeInstallmentRepository.save(feeInstallment);
	}

	@Override
	public List<FeeInstallment> pendingInstallments(long userId) {
		return null;
	}

	@Override
	public Optional<FeeInstallment> retrieveFeeInstallmentById(int feeInstallmentId) {
		return feeInstallmentRepository.findById(feeInstallmentId);
	}

	@Override
	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(int feeId) {
		Optional<Fee> fee= feeRepository.findById(feeId);
		if(fee.isPresent()) {			
			return feeInstallmentRepository.findByFee(fee.get());
		}
		return null;
	}
	

}
