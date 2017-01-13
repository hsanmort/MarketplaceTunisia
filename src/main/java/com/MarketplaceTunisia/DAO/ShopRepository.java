package com.MarketplaceTunisia.DAO;

import java.util.Date;
import java.util.List;

import com.MarketplaceTunisia.Entities.Seller;
import com.MarketplaceTunisia.Entities.Shop;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopRepository extends JpaRepository<Shop, Integer>{

	@Query("select s from Shop s where s.description like :x or s.nameShop like :x")
	public Page<Shop> findByMc(@Param("x") String mc, Pageable pageable);
	public Page<Shop> findBynameShop(String nameShop, Pageable pageable);
	public Page<Shop> findBydateCreation(Date dateCreation, Pageable pageable);
	public Page<Shop> findByseller(Seller seller, Pageable pageable);
	public List<Shop> findByseller(Seller seller);

	public Shop findByIdShop(Long idShop);

}
