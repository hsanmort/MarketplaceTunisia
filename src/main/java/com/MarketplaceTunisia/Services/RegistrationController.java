package com.MarketplaceTunisia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.RoleRepository;
import com.MarketplaceTunisia.DAO.UserRepository;
import com.MarketplaceTunisia.Entities.Buyer;
import com.MarketplaceTunisia.Entities.Role;
import com.MarketplaceTunisia.Entities.Seller;
import com.MarketplaceTunisia.Entities.User;

@RestController
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;
	//partie role
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value="/user/buyerReg",method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void RegistrationBuyer(@RequestBody Buyer u){
		Role r2=roleRepository.findOne("INVITE");
		Role r=roleRepository.findOne("BUYER");
		u.getRoles().add(r);
		u.getRoles().add(r2);

		userRepository.save(u);
	}
	@RequestMapping(value="/user/SellerReg",method=RequestMethod.POST)
	public void RegistrationSeller(@RequestBody Seller u){
		Role r2=roleRepository.findOne("INVITE");
		Role r=roleRepository.findOne("SELLER");
		u.getRoles().add(r);
		u.getRoles().add(r2);

		userRepository.save(u);
	}
	

}