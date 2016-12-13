package com.MarketplaceTunisia.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.ProductRepository;
import com.MarketplaceTunisia.Entities.Category;

import com.MarketplaceTunisia.Entities.Product;
import com.MarketplaceTunisia.Entities.Shop;

@RestController
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping(value="/product/save",method=RequestMethod.POST)
	public void saveProduct(@RequestBody Product product){
		productRepository.save(product);
	}
	
	@RequestMapping(value="/product/delete")
	public void deleteProduct(int idProduct){
		productRepository.delete(idProduct);
	}
	
	@RequestMapping(value="/product/update")
	public Product updateProduct(Product product){
		return productRepository.saveAndFlush(product);
	}
	
	@RequestMapping(value="/product/all", method=RequestMethod.GET)
	public List<Product> liste() {
		return productRepository.findAll();
	}
	
	@RequestMapping("/product/findByMc")
	public Page<Product> getProductsByMc(String mc, int page){
		return productRepository.findByMc("%"+mc+"%", new PageRequest(page,5));
	}
	
	@RequestMapping("/complaint/findByCategory")
	public Page<Product> getProductsByCategory(Category category, int page){
	return productRepository.findByCategory(category, new PageRequest(page,5));
	}
	
	@RequestMapping("/complaint/findByShop")
	public Page<Product> getProductsByShop(Shop shop, int page){
	return productRepository.findByShop(shop, new PageRequest(page,5));
	}
	
	@RequestMapping("/complaint/findByNameProd")
	public Page<Product> getProductsByNameProduct(String name, int page){
	return productRepository.findBynameProduct(name, new PageRequest(page,5));
	}
	
	@RequestMapping("/complaint/findByDiscount")
	public Page<Product> getProductsByDiscount(Boolean discount, int page){
	return productRepository.findBydiscount(discount, new PageRequest(page,5));
	}
	
	@RequestMapping("/complaint/findByPrice")
	public Page<Product> getProductsByPrice(double price, int page){
	return productRepository.findByprice(price, new PageRequest(page,5));
	}
	
	@RequestMapping("/complaint/findByReviews")
	public Page<Product> getProductsByReviews(double reviews, int page){
	return productRepository.findByReviews(reviews, new PageRequest(page,5));
	}

}
