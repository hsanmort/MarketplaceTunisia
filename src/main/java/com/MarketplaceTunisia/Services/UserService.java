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
import com.MarketplaceTunisia.Entities.User;

@RestController
public class UserService {

	@Autowired
	private UserRepository userRepository;
	//partie role
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value="/user/save",method=RequestMethod.POST)
	public void saveUser(@RequestBody User user){
		userRepository.save(user);
	}
	
	@RequestMapping(value="/user/delete")
	public void deleteUser(int idUser){
		userRepository.delete(idUser);
	}
	
	@RequestMapping(value="/user/update")
	public User updateUser(User user){
		return userRepository.saveAndFlush(user);
	}
	
	@RequestMapping(value="/user/all", method=RequestMethod.GET)
	public Page<User> allUsers(int page) {
		return userRepository.findAll(new PageRequest(page, 5));
	}
	
	@RequestMapping("/user/findByMc")
	public Page<User> getUsersByMc(String mc, int page){
		return userRepository.findByMc("%"+mc+"%", new PageRequest(page,5));
	}
	
	@RequestMapping("/user/findByName")
	public Page<User> getUsersByName(String name, int page){
		return userRepository.findByname(name, new PageRequest(page,5));
	}
	@RequestMapping(value="/user/findByMailAndPwd", method=RequestMethod.POST)
	public User getUsersByMailAndPwd(String mail,String pwd){
		return userRepository.findBymailAndPwd(mail, pwd);
	}
	
	@RequestMapping("/user/findByStatus")
	public Page<User> getUsersByStatus(Boolean status, int page){
		return userRepository.findBystatus(status, new PageRequest(page,5));
	}
	
	@RequestMapping("/user/findByAdress")
	public Page<User> getUsersByAdress(Adress adress, int page){
		return userRepository.findByadress(adress, new PageRequest(page,5));
	}
	@RequestMapping("/user/findByMail")
	public User getUsersByMail(String mail){
		return userRepository.findBymail(mail);
	}
	
	
	
	
}