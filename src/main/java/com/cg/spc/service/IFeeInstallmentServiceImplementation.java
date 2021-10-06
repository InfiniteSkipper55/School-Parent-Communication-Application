package com.cg.spc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Fee;
import com.cg.spc.entities.FeeInstallment;
import com.cg.spc.entities.Student;
import com.cg.spc.repository.FeeInstallmentRepository;
import com.cg.spc.repository.FeeRepository;
import com.cg.spc.repository.StudentRepository;

@Service
public class IFeeInstallmentServiceImplementation implements FeeInstallmentService {
	@Autowired
	private FeeInstallmentRepository feeInstallmentRepository;
	
	@Autowired
	private FeeRepository feeRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public FeeInstallment makePayment(FeeInstallment feeInstallment) {
		Fee fee  = feeInstallment.getFee();
		if(fee != null) {
			int feeId = fee.getFeeId();
			Optional<Fee> feeContainer = feeRepository.findById(feeId);
			if(feeContainer.isPresent()) {
				feeInstallment.setFee(feeContainer.get());
			}
		}
		return feeInstallmentRepository.save(feeInstallment);
	}

	@Override
	public List<FeeInstallment> pendingInstallments(long userId) {
		Optional<Student> student = studentRepository.findById(userId);
		if (student.isPresent()) {
			Fee fee = feeRepository.findByStudent(student.get());
			if(fee!=null) {
				return feeInstallmentRepository.findByFee(fee);
			}
		}
		return null;
	}

	@Override
	public Optional<FeeInstallment> retrieveFeeInstallmentById(int feeInstallmentId) {
		return feeInstallmentRepository.findById(feeInstallmentId);
	}

	@Override
	public List<FeeInstallment> retrieveAllFeeInstallmentsByFee(int feeId) {
		Optional<Fee> fee = feeRepository.findById(feeId);
		if(fee.isPresent()) {			
			return feeInstallmentRepository.findByFee(fee.get());
		}
		return null;
	}
	

}
