package com.MarketplaceTunisia.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MarketplaceTunisia.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
