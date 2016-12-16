package com.MarketplaceTunisia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.AdressRepository;
import com.MarketplaceTunisia.Entities.Adress;

@RestController
public class AdressService {

	@Autowired
	AdressRepository adressRepository;
	
	@RequestMapping(value="/adress/save",method=RequestMethod.POST)
	public void saveAdress(@RequestBody Adress adress){
		adressRepository.save(adress);
	}
	
	@RequestMapping(value="/adress/delete")
	public void deleteAdress(int idAdress){
		adressRepository.delete(idAdress);
	}
	
	@RequestMapping(value="/adress/update")
	public Adress updateAdress(Adress adress){
		return adressRepository.saveAndFlush(adress);
	}
	
	@RequestMapping(value="/adress/all", method=RequestMethod.GET)
	public List<Adress> allAdress() {
		return adressRepository.findAll();
	}
}
