package com.cg.spc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.spc.entities.Fee;
import com.cg.spc.entities.FeeInstallment;

public interface FeeInstallmentRepository extends JpaRepository<FeeInstallment, Integer> {

	@Query(value = "SELECT * FROM FEE_INSTALLMENT_1 WHERE FEE_COLUMN = ?1", nativeQuery =true)
	List<FeeInstallment> findByFee(Fee fee);
	
}
