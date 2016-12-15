package com.MarketplaceTunisia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.RoleRepository;
import com.MarketplaceTunisia.DAO.UserRepository;
import com.MarketplaceTunisia.Entities.Adress;
import com.MarketplaceTunisia.Entities.Role;
import com.MarketplaceTunisia.Entities.User;

@RestController
//@Secured(value={"ROLE_ADMIN"})
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;
	//partie role
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value="/user/buyerReg",method=RequestMethod.POST)
	public void RegistrationBuyer(@RequestBody User u){
		
		Role r=roleRepository.findOne("BUYER");
		u.getRoles().add(r);
		userRepository.save(u);
	}
	@RequestMapping(value="/user/SellerReg",method=RequestMethod.POST)
	public void RegistrationSeller(@RequestBody User u){
		
		Role r=roleRepository.findOne("SELLER");
		u.getRoles().add(r);
		userRepository.save(u);
	}
	

}