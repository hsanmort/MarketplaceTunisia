package com.MarketplaceTunisia.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MarketplaceTunisia.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
