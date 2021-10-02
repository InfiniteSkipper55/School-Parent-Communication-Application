package com.cg.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.spc.entities.Fee;
import com.cg.spc.entities.FeeInstallment;

public interface IFeeInstallmentRepository extends JpaRepository<FeeInstallment, Integer> {

	List<FeeInstallment> findByFee(Fee fee);
	
}
