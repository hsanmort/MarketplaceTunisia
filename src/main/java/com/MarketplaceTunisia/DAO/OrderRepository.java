package com.MarketplaceTunisia.DAO;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



import com.MarketplaceTunisia.Entities.Order;



public interface OrderRepository extends JpaRepository<Order, Integer>{

		public Page<Order> findBydateO(Date date, Pageable pageable);
		public Page<Order> findAll(Pageable p);
}
