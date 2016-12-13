package com.MarketplaceTunisia.DAO;

import java.awt.print.Pageable;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.MarketplaceTunisia.Entities.Complaint;



public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

	@Query("select c from Complaint c where c.description like :x")
	public Page<Complaint> findByMc(@Param("x") String mc, Pageable pageable);
	public Page<Complaint> findBydateComplaint(Date date, Pageable pageable);
	
}
