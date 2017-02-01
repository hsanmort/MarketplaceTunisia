package com.MarketplaceTunisia.DAO;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;





import com.MarketplaceTunisia.Entities.Adress;
import com.MarketplaceTunisia.Entities.Buyer;
import com.MarketplaceTunisia.Entities.Complaint;
import com.MarketplaceTunisia.Entities.Order;
import com.MarketplaceTunisia.Entities.User;



public interface OrderRepository extends JpaRepository<Order, Integer>{

	
	
	public Page<Order> findBydateO(Date date, Pageable pageable);
	//public Page<Order> findAll(Pageable p);
	
	
	public Page<Order> findByBuyer(Buyer buyer, Pageable pageable);
	public Page<Order> findByadress(Adress adress, Pageable pageable);
	
}
