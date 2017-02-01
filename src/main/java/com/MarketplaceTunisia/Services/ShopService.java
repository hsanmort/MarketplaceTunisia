package com.MarketplaceTunisia.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.SellerRepository;
import com.MarketplaceTunisia.DAO.ShopRepository;
import com.MarketplaceTunisia.Entities.Product;
import com.MarketplaceTunisia.Entities.Seller;
import com.MarketplaceTunisia.Entities.Shop;


@RestController
public class ShopService {

	@Autowired
	ShopRepository shopRepository;
	@Autowired
	SellerRepository sellerRepository;
	
	@RequestMapping(value="/shop/save",method=RequestMethod.POST)
	public void saveShop(@RequestBody Shop shop,@RequestParam int idUser){
		shopRepository.save(shop);
		Seller seller=sellerRepository.findOne(idUser);
		shop.setSeller(seller);
		shopRepository.saveAndFlush(shop);
		
	}
	@RequestMapping(value="/shop/sav",method=RequestMethod.POST)
	public void savShop(@RequestBody Shop shop){
		shopRepository.save(shop);
		int idUser=1;
		Seller seller= sellerRepository.findOne(idUser);
		System.out.println(seller.getLastName());
		shop.setSeller(seller);
		shopRepository.saveAndFlush(shop);
		
	}
	
	@RequestMapping(value="/shop/delete")
	public void deleteShop(int idShop){
		shopRepository.delete(idShop);
	}
	
	@RequestMapping(value="/shop/update")
	public Shop updateShop(Shop shop){
		return shopRepository.saveAndFlush(shop);
	}
	
	@RequestMapping(value="/shop/all", method=RequestMethod.GET)
	public List<Shop> allShops() {
		return shopRepository.findAll();
	}
	
	@RequestMapping("/shop/findByMc")
	public Page<Shop> getShopsByMc(String mc, int page){
		return shopRepository.findByMc("%"+mc+"%", new PageRequest(page,5));
	}
	
	@RequestMapping("/shop/findByName")
	public Page<Shop> getShopsByName(String nameShop, int page){
		return shopRepository.findBynameShop(nameShop, new PageRequest(page,5));
	}
	
	@RequestMapping("/shop/findByDateCreation")
	public Page<Shop> getShopsByDateCreation(Date dateCreation, int page){
		return shopRepository.findBydateCreation(dateCreation, new PageRequest(page,5));
	}
	
	@RequestMapping("/shop/findBySeller")
	public Page<Shop> getShopsBySeller(Seller seller, int page){
		return shopRepository.findByseller(seller, new PageRequest(page,5));
	}
	@RequestMapping("/shop/findBySellers")
	public List<Shop> getShopsBySellers(Seller seller){
		return shopRepository.findByseller(seller);
	}
	@RequestMapping("/shop/findByIdShop")
	public Shop getShopsByIdShop(Long idShop){
		return shopRepository.findByIdShop(idShop);
	}
		
}
