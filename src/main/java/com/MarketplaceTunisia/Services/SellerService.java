package com.MarketplaceTunisia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.SellerRepository;
import com.MarketplaceTunisia.Entities.Seller;

@RestController
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	
	@RequestMapping(value="/seller/save",method=RequestMethod.POST)
	public void saveSeller(@RequestBody Seller seller){
		sellerRepository.save(seller);
	}
	
	@RequestMapping(value="/seller/delete")
	public void deleteSeller(int idSeller){
		sellerRepository.delete(idSeller);
	}
	
	@RequestMapping(value="/seller/update")
	public Seller updateSeller(Seller seller){
		return sellerRepository.saveAndFlush(seller);
	}
	
	@RequestMapping(value="/seller/all", method=RequestMethod.GET)
	public List<Seller> allSellers() {
		return sellerRepository.findAll();
	}
	
}