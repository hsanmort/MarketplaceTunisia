package com.MarketplaceTunisia.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
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
@Secured(value={"ROLE_ADMIN"})
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
	public List<User> allUsers() {
		return userRepository.findAll();
	}
	
	@RequestMapping("/user/findByMc")
	public Page<User> getUsersByMc(String mc, int page){
		return userRepository.findByMc("%"+mc+"%", new PageRequest(page,5));
	}
	
	@RequestMapping("/user/findByName")
	public Page<User> getUsersByName(String name, int page){
		return userRepository.findByname(name, new PageRequest(page,5));
	}
//	@RequestMapping("/user/findByMail")
//	public Page<User> getUsersByMail(String mail, int page){
//		return userRepository.findBymail(mail, new PageRequest(page,5));
//	}
	
	@RequestMapping("/user/findByStatus")
	public Page<User> getUsersByStatus(Boolean status, int page){
		return userRepository.findBystatus(status, new PageRequest(page,5));
	}
	
	@RequestMapping("/user/findByAdress")
	public Page<User> getUsersByAdress(Adress adress, int page){
		return userRepository.findByadress(adress, new PageRequest(page,5));
	}
	
	@RequestMapping(value="/getLogedUser")
	public Map<String,Object> getLogedUser(HttpServletRequest httpServletRequest){
		HttpSession httpSession=httpServletRequest.getSession();
		SecurityContext securityContext=(SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username=securityContext.getAuthentication().getName();
		List<String> roles=new ArrayList<>();
		for(GrantedAuthority ga:securityContext.getAuthentication().getAuthorities()){
			roles.add(ga.getAuthority());
		}
		Map<String, Object> params=new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		return params;
	}
	
}