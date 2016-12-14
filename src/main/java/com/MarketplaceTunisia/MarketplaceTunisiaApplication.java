package com.MarketplaceTunisia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.MarketplaceTunisia.DAO.BuyerRepository;
import com.MarketplaceTunisia.DAO.UserRepository;
import com.MarketplaceTunisia.Entities.Buyer;
import com.MarketplaceTunisia.Entities.User;


@SpringBootApplication
public class MarketplaceTunisiaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(MarketplaceTunisiaApplication.class, args);
		BuyerRepository buyerRepository=ctx.getBean(BuyerRepository.class);
		
		Buyer u = new Buyer("hsan", "akrout", "hsan.akrout@gmail.com", "mimi");
		
		buyerRepository.save(u);

//		Buyer u2= new Buyer("haythem", "gara", "haythem.gara@gmail.com", "papi");
//		
//		Seller u3=new Seller("naoufel", "akrout", "baw.akrout@gmail.com", "lili");
//		Seller u4= new Seller("zeineb", "gara", "zinou.gara@gmail.com", "zizi");
		
	}
}
