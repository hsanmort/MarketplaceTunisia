package com.MarketplaceTunisia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.MarketplaceTunisia.DAO.BuyerRepository;
import com.MarketplaceTunisia.DAO.CategoryRepository;
import com.MarketplaceTunisia.DAO.SellerRepository;
import com.MarketplaceTunisia.DAO.UserRepository;
import com.MarketplaceTunisia.Entities.Buyer;
import com.MarketplaceTunisia.Entities.Category;
import com.MarketplaceTunisia.Entities.Seller;
import com.MarketplaceTunisia.Entities.User;




@SpringBootApplication
public class MarketplaceTunisiaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(MarketplaceTunisiaApplication.class, args);
		
		SellerRepository sellerRepository=ctx.getBean(SellerRepository.class);
//		CategoryRepository categoryRepository=ctx.getBean(CategoryRepository.class);
//		categoryRepository.save(new Category("Info"));
		sellerRepository.save(new Seller("hsan", "akrout", "hsan.akrout@gmail.com", "mimi"));
//		Seller u = new Seller("hsan", "akrout", "hsan.akrout@gmail.com", "mimi");	
//		System.out.println(u.getPwd());
//		sellerRepository.flush();
//		sellerRepository.save(u);
//		buyerRepository.save(u);
//		Buyer u1 = new Buyer("xxx", "xx", "xxx", "xx");
//		buyerRepository.save(u1);


//		Buyer u2= new Buyer("haythem", "gara", "haythem.gara@gmail.com", "papi");
//		
//		Seller u3=new Seller("naoufel", "akrout", "baw.akrout@gmail.com", "lili");
//		Seller u4= new Seller("zeineb", "gara", "zinou.gara@gmail.com", "zizi");
		
	}
}
