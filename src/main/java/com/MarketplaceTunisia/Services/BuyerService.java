package com.MarketplaceTunisia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.BuyerRepository;
import com.MarketplaceTunisia.Entities.Buyer;
import com.MarketplaceTunisia.Entities.User;

@RestController
public class BuyerService {

	@Autowired
	private BuyerRepository buyerRepository;
	
	@RequestMapping(value="/buyer/save",method=RequestMethod.POST)
	public void saveBuyer(@RequestBody Buyer buyer){
		buyerRepository.save(buyer);
	}
	
	@RequestMapping(value="/buyer/delete")
	public void deleteBuyer(int idBuyer){
		buyerRepository.delete(idBuyer);
	}
	
	@RequestMapping(value="/buyer/update")
	public Buyer updateBuyer(Buyer buyer){
		return buyerRepository.saveAndFlush(buyer);
	}
	
	@RequestMapping(value="/buyer/all", method=RequestMethod.GET)
	public List<Buyer> allBuyers() {
		return buyerRepository.findAll();
	}
	
	
}