package com.MarketplaceTunisia.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.MarketplaceTunisia.Entities.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
	
	
	@Query("select b from Buyer b where b.name like :x or b.lastName like :x or b.status like :x")
	public Page<Buyer> findByMc(@Param("x") String mc, Pageable pageable);
}
