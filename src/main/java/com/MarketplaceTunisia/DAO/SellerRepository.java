package com.MarketplaceTunisia.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MarketplaceTunisia.Entities.Buyer;
import com.MarketplaceTunisia.Entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
