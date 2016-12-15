package com.MarketplaceTunisia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.MarketplaceTunisia.DAO.BuyerRepository;
import com.MarketplaceTunisia.Entities.Buyer;


@SpringBootApplication
public class MarketplaceTunisiaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(MarketplaceTunisiaApplication.class, args);
		BuyerRepository buyerRepository=ctx.getBean(BuyerRepository.class);
		
		Buyer u = new Buyer("aa", "bb", "hsan.akrout@gmail.com", "mimi");
		System.out.println(u.getName()+" "+u.getLastName()+" "+u.getMail()+" "+u.getPwd());
		
		buyerRepository.save(u);
		
//		Buyer u2= new Buyer("haythem", "gara", "haythem.gara@gmail.com", "papi");
//		
//		Seller u3=new Seller("naoufel", "akrout", "baw.akrout@gmail.com", "lili");
//		Seller u4= new Seller("zeineb", "gara", "zinou.gara@gmail.com", "zizi");
		
	}
}
