package com.MarketplaceTunisia.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.ProductRepository;
import com.MarketplaceTunisia.DAO.ShopRepository;
import com.MarketplaceTunisia.Entities.Category;
import com.MarketplaceTunisia.Entities.Product;
import com.MarketplaceTunisia.Entities.Shop;

@RestController
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ShopRepository shopRepository;
	
	@RequestMapping(value="/product/save",method=RequestMethod.POST)
	public void saveProduct(@RequestBody Product product, @RequestParam Long idShop){
		productRepository.save(product);
		idShop=(long) idShop;
		Shop shop= shopRepository.findByIdShop(idShop);
		System.out.println(shop.getNameShop());
		System.out.println(shop.getIdShop());
		product.setShop(shop);
		productRepository.saveAndFlush(product);
		
		
	}
	
	@RequestMapping(value="/product/sav",method=RequestMethod.POST)
	public void savProduct(@RequestBody Product product){
		productRepository.save(product);
		long idShop=3;
		Shop shop= shopRepository.findByIdShop(idShop);
		System.out.println(shop.getNameShop());
		product.setShop(shop);
		productRepository.saveAndFlush(product);
		
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
	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	@RequestMapping(value="/productsByShop/all", method=RequestMethod.GET)
	public List<Product> allProductsByShop(@RequestParam Long idShop) {
		Shop shop=shopRepository.findByIdShop(idShop);
		return productRepository.findByShop(shop);
	}
	@RequestMapping("/product/findByMc")
	public Page<Product> getProductsByMc(String mc, int page){
		return productRepository.findByMc("%"+mc+"%", new PageRequest(page,5));
	}
	
	@RequestMapping("/product/findByCategory")
	public Page<Product> getProductsByCategory(Category category, int page){
	return productRepository.findByCategory(category, new PageRequest(page,5));
	}
	
	@RequestMapping("/product/findByNameProd")
	public Page<Product> getProductsByNameProduct(String name, int page){
	return productRepository.findBynameProduct(name, new PageRequest(page,5));
	}
	
	@RequestMapping("/product/findByDiscount")
	public Page<Product> getProductsByDiscount(Boolean discount, int page){
	return productRepository.findBydiscount(discount, new PageRequest(page,5));
	}
	
	@RequestMapping("/product/findByPrice")
	public Page<Product> getProductsByPrice(double price, int page){
	return productRepository.findByprice(price, new PageRequest(page,5));
	}
	
	@RequestMapping("/product/findByReviews")
	public Page<Product> getProductsByReviews(double reviews, int page){
	return productRepository.findByReviews(reviews, new PageRequest(page,5));
	}
	
	@RequestMapping("/product/findByIdProduct")
	public Product getProductsByidProduct( int idProduct){
	return productRepository.findByidProduct(idProduct);
	}

}
