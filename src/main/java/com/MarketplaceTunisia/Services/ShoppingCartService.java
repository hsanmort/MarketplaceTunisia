package com.MarketplaceTunisia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.MarketplaceTunisia.DAO.ShoppingCartRepository;
import com.MarketplaceTunisia.Entities.ShoppingCart;

@RestController
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@RequestMapping(value="/shoppingCart/save",method=RequestMethod.POST)
	public void saveShoppingCart(@RequestBody ShoppingCart shoppingCart){
		shoppingCartRepository.save(shoppingCart);
	}
	
	@RequestMapping(value="/shoppingCart/delete")
	public void deleteShoppingCart(int idAdress){
		shoppingCartRepository.delete(idAdress);
	}
	
	@RequestMapping(value="/shoppingCart/update")
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart){
		return shoppingCartRepository.saveAndFlush(shoppingCart);
	}
	
	@RequestMapping(value="/shoppingCart/all", method=RequestMethod.GET)
	public List<ShoppingCart> allShoppingCarts() {
		return shoppingCartRepository.findAll();
	}
}
