package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import com.cg.spc.entities.FeeInstallment;

public interface FeeInstallmentService {
	public FeeInstallment makePayment(FeeInstallment feeInstallment);
	public List<FeeInstallment> pendingInstallments(long userId);
	public Optional<FeeInstallment> retrieveFeeInstallmentById(int feeInstallmentId);
	List<FeeInstallment> retrieveAllFeeInstallmentsByFee(int feeId);

}
