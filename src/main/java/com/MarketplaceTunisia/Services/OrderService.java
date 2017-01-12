
package com.MarketplaceTunisia.Services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.BuyerRepository;
import com.MarketplaceTunisia.DAO.OrderRepository;
import com.MarketplaceTunisia.DAO.SellerRepository;
import com.MarketplaceTunisia.Entities.Buyer;
import com.MarketplaceTunisia.Entities.Complaint;
import com.MarketplaceTunisia.Entities.Order;
import com.MarketplaceTunisia.Entities.Seller;

@RestController
public class  OrderService {
	@Autowired
	OrderRepository OrderRepository;
	@Autowired
	BuyerRepository buyerRepository;
	
	
	@RequestMapping(value="/order/save",method=RequestMethod.POST)
	public void saveComplaint(@RequestBody Order order){
		OrderRepository.save(order);
	}
	
	

	
	

	
	}