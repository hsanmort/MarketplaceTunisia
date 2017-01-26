package com.MarketplaceTunisia.DAO;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.MarketplaceTunisia.Entities.Category;
import com.MarketplaceTunisia.Entities.Product;
import com.MarketplaceTunisia.Entities.Shop;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("select p from Product p where p.nameProduct like :x or p.description like :x")
	public Page<Product> findByMc(@Param("x") String mc, Pageable pageable);
	
	public List<Product> findByShop(Shop shop);
	
	public Page<Product> findByCategory(Category category, Pageable pageable);
	//public Page<Product> findByShop(Shop shop, Pageable pageable);
	public Page<Product> findBynameProduct (String name, Pageable pageable);
	public Page<Product> findBydiscount(Boolean discount, Pageable pageable);
	public Page<Product> findByprice(double price, Pageable pageable);
	public Page<Product> findByReviews(double reviews, Pageable pageable);
	
	public Product findByidProduct(int idProduct);


	

}
