package com.MarketplaceTunisia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.MarketplaceTunisia.DAO.BuyerRepository;
import com.MarketplaceTunisia.DAO.CategoryRepository;
import com.MarketplaceTunisia.DAO.RoleRepository;
import com.MarketplaceTunisia.DAO.SellerRepository;
import com.MarketplaceTunisia.DAO.UserRepository;
import com.MarketplaceTunisia.Entities.Buyer;
import com.MarketplaceTunisia.Entities.Category;
import com.MarketplaceTunisia.Entities.Role;
import com.MarketplaceTunisia.Entities.Seller;
import com.MarketplaceTunisia.Entities.User;




@SpringBootApplication
public class MarketplaceTunisiaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(MarketplaceTunisiaApplication.class, args);
		
		SellerRepository sellerRepository=ctx.getBean(SellerRepository.class);
		RoleRepository roleRepository=ctx.getBean(RoleRepository.class);
		BuyerRepository buyerRepository=ctx.getBean(BuyerRepository.class);
		
//		List<Role> liste=new ArrayList<Role>();
//		Role r1=new Role();
//		r1=roleRepository.getOne("INVITE");
////ajout de seller
//		Seller s1=new Seller("hsan", "akrout", "hsan.akrout@gmail.com", "mimi");
//		liste=s1.getRoles();
//		
//		liste.add(r1);
//		s1.setRoles(liste);
//		sellerRepository.save(s1);
////ajout de buyer
//		Buyer s2=new Buyer("haythem", "gara", "haythem.gara@gmail.com", "toto");
//		liste=s2.getRoles();
//		
//		liste.add(r1);
//		buyerRepository.save(s2);


		
	}
}
