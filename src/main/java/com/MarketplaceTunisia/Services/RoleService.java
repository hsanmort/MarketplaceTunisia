package com.MarketplaceTunisia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.RoleRepository;
import com.MarketplaceTunisia.DAO.UserRepository;
import com.MarketplaceTunisia.Entities.Role;
import com.MarketplaceTunisia.Entities.ShoppingCart;
import com.MarketplaceTunisia.Entities.User;

@RestController
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/role/save",method=RequestMethod.POST)
	public void saveRole(@RequestBody Role role){
		roleRepository.save(role);
	}
	
	@RequestMapping(value="/role/delete")
	public void deleteRole(String role){
		roleRepository.delete(role);
	}
	
	@RequestMapping(value="/role/update")
	public Role updateShoppingCart(Role role){
		return roleRepository.saveAndFlush(role);
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Role> allRoles() {
		return roleRepository.findAll();
	}
	
	@RequestMapping(value="/user/role/addRoleToUser")
	public User addRoleToUser(String mail, String role)
	{
		User u=userRepository.findBymail(mail);
		Role r=roleRepository.findOne(role);
		u.getRoles().add(r);
		userRepository.save(u);
		return u;
	}
}
