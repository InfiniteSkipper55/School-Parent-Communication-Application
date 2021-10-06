package com.cg.spc.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spc.entities.Fee;
import com.cg.spc.entities.Student;
import com.cg.spc.repository.FeeRepository;
import com.cg.spc.repository.StudentRepository;

@Service
public class IFeeServiceImplementation implements FeeService {
	@Autowired
	FeeRepository feeRepository;
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Fee addFee(Fee fee) {
		Student student  = fee.getStudent();
		if(student != null) {
			long studentId = student.getUserId();
			Optional<Student> studentContainer = studentRepository.findById(studentId);
			if(studentContainer.isPresent()) {
				fee.setStudent(studentContainer.get());
			}
		}
		return feeRepository.save(fee);
	}

	@Override
	public Fee deleteFee(int feeId) {
		Optional<Fee> existingFeeContainer = feeRepository.findById(feeId);
		Fee existingFee = null;
		if (existingFeeContainer.isPresent()) {
			existingFee = existingFeeContainer.get();
			feeRepository.deleteById(feeId);
		}
		return existingFee;
	}

	@Override
	public Fee updateFee(Fee fee) {
		Optional<Fee> optional = feeRepository.findById(fee.getFeeId());
		if (optional.isPresent()) {
			feeRepository.saveAndFlush(fee);
		}
		return fee;
	}

	@Override
	public Optional<Fee> retrieveFee(int feeId) {
		return feeRepository.findById(feeId);
	}

	@Override
	public List<Fee> retrieveFeeByStudent(long userId) {
		Optional<Student> student = studentRepository.findById(userId);
		if(student.isPresent()) {			
			return feeRepository.findByStudentId(student.get());
		}
		return null;
	}

	@Override
	public List<Fee> retrieveAllFeeByMonth(Date startMonthYear) {
		List<Fee> existingFee = feeRepository.findByDate(startMonthYear);
		Collections.sort(existingFee, new Comparator<Fee>() {
		    public int compare(Fee m1, Fee m2) {
		        return m1.getStartMonthYear().compareTo(m2.getStartMonthYear());
		    }
		});
		return existingFee;
	}
	

}
