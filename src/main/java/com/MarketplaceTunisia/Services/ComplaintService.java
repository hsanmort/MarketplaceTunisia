package com.MarketplaceTunisia.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.ComplaintRepository;
import com.MarketplaceTunisia.Entities.Complaint;

@RestController
public class ComplaintService {
	@Autowired
	ComplaintRepository complaintrepository;
	
	@RequestMapping(value="/complaint/save",method=RequestMethod.POST)
	public void saveComplaint(@RequestBody Complaint complaint){
		complaintrepository.save(complaint);
	}
	
	@RequestMapping(value="/complaint/delete")
	public void deleteComplaint(int idComplaint){
		complaintrepository.delete(idComplaint);
	}
	
	@RequestMapping(value="/complaint/update")
	public Complaint updateComplaint(Complaint complaint){
		return complaintrepository.saveAndFlush(complaint);
	}
	
	@RequestMapping(value="/complaint/all", method=RequestMethod.GET)
	public List<Complaint> liste() {
		return complaintrepository.findAll();
	}
	
	@RequestMapping("/complaint/findByMc")
	public Page<Complaint> getComplaintsByMc(String mc, int page){
		return complaintrepository.findByMc("%"+mc+"%", new PageRequest(page,5));
	}
	
	@RequestMapping("/complaint/findByDate")
	public Page<Complaint> getComplaintsByDate(Date date, int page){
	return complaintrepository.findBydateComplaint(date, new PageRequest(page,5));
	}
	
	}
