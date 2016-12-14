package com.MarketplaceTunisia.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MarketplaceTunisia.Entities.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
	
	

}
