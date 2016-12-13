package com.MarketplaceTunisia.DAO;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.MarketplaceTunisia.Entities.Category;
import com.MarketplaceTunisia.Entities.Product;
import com.MarketplaceTunisia.Entities.Shop;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("select p from Product p where p.nameProduct like :x or p.description like :x")
	public Page<Product> findByMc(@Param("x") String mc, Pageable pageable);
	public Page<Product> findByCategory(Category category, Pageable pageable);
	public Page<Product> findByShop(Shop shop, Pageable pageable);
}
