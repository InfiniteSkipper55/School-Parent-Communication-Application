package com.cg.spc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cg.spc.entities.Fee;

public interface FeeService {
	public Fee addFee(Fee fee);
	public Fee deleteFee(int feeId);
	public Fee updateFee(Fee fee);
	public Optional<Fee> retrieveFee(int feeId);
	public List<Fee> retrieveFeeByStudent(long userId);
	public List<Fee> retrieveAllFeeByMonth(Date startMonthYear);

}
