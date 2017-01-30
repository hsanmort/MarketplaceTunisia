package com.MarketplaceTunisia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.SellerRepository;
import com.MarketplaceTunisia.DAO.ShopRepository;
import com.MarketplaceTunisia.DAO.UserRepository;
import com.MarketplaceTunisia.Entities.Seller;
import com.MarketplaceTunisia.Entities.Shop;
import com.MarketplaceTunisia.Entities.User;

@RestController
public class SellerService {

	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ShopRepository shopRepository;
	
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
	public Page<Seller> allSellers(int page) {
		return sellerRepository.findAll(new PageRequest(page, 5));
	}
	@RequestMapping(value="/seller/alls", method=RequestMethod.GET)
	public List<Seller> Sellers() {
		return sellerRepository.findAll();
	}
	
	
	@RequestMapping("/seller/findByMc")
	public Page<Seller> getSellerByMc(String mc, int page){
		return sellerRepository.findByMc("%"+mc+"%", new PageRequest(page,5));
	}
	
//	@RequestMapping("/seller/UpdateSeller")
//	public Seller UpdateSeller(int id){
//		return sellerRepository.UpdateSeller(id);
//	}	
	
 
	@RequestMapping(value="/seller/UpdateStatus")
	public void UpdateStatus(String sta,int id){
		 sellerRepository.UpdateStatus(sta,id);
		}
	@RequestMapping("/seller/findByIdSeller")
	public User getShopsByIdSeller(int idSeller){
		return userRepository.findByIdUser(idSeller);
	}
	@RequestMapping("/seller/findSellerByShop")
	public Seller getSellerByIdShop(Long idShop){
		
		return sellerRepository.FindSellerByShop(idShop); 
	}
	
}