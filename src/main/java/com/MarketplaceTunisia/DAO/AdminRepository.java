package com.MarketplaceTunisia.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MarketplaceTunisia.Entities.Administrator;

public interface AdminRepository extends JpaRepository<Administrator, Integer> {

}
