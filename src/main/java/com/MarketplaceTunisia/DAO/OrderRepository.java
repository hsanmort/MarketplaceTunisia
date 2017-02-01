package com.MarketplaceTunisia.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MarketplaceTunisia.Entities.Adress;
import com.MarketplaceTunisia.Entities.Buyer;
import com.MarketplaceTunisia.Entities.Order;



public interface OrderRepository extends JpaRepository<Order, Integer>{

	
	
	public Page<Order> findBydateO(Date date, Pageable pageable);
	//public Page<Order> findAll(Pageable p);
	@Query("select o from Order o ")
	public List<Order> findallO();
	
	public Page<Order> findByBuyer(Buyer buyer, Pageable pageable);
	public Page<Order> findByadress(Adress adress, Pageable pageable);
	
}
