package com.MarketplaceTunisia.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MarketplaceTunisia.Entities.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

}
