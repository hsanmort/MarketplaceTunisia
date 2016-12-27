package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.MarketplaceTunisia.Entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("SE")
@Table(name = "t_seller")
public class Seller extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String companyName;

	private int companyId;
	
	@OneToMany(mappedBy="seller")
	private List<Shop> shops;
	
	@OneToMany(mappedBy="seller",cascade=CascadeType.REMOVE)
	private List<Complaint> complaints;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	@JsonIgnore
	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}



	public Seller(String name, String lastName, String mail,
			String pwd, char gender, long tel, byte[] picture,
			Adress adress, String companyName, int companyId, List<Shop> shops,
			List<Complaint> complaints) {
		super(name, lastName, mail, pwd, gender, tel, picture,
				adress);
		this.companyName = companyName;
		this.companyId = companyId;
		this.shops = shops;
		this.complaints = complaints;
		this.setStatus(false);
		
		//ajout role seller
//		List<Role> listRoles=new ArrayList<Role>();
//		listRoles=super.getRoles();
//		listRoles.add(new Role("SELLER"));
//		this.setRoles(listRoles);
		
	}

	public Seller(String companyName, int companyId, List<Shop> shops,
			List<Complaint> complaints) {
		super();
		this.companyName = companyName;
		this.companyId = companyId;
		this.shops = shops;
		this.complaints = complaints;
		this.setStatus(false);

		//ajout role SELLER
//		List<Role> listRoles=new ArrayList<Role>();
//		listRoles=super.getRoles();
//		listRoles.add(new Role("SELLER"));
//		this.setRoles(listRoles);
	}

	public Seller() {
		super();
		
		//ajout role seller
//		List<Role> listRoles=new ArrayList<Role>();
//		listRoles=super.getRoles();
//		listRoles.add(new Role("SELLER"));
//		this.setRoles(listRoles);
	}

	public Seller(String name, String lastName, String mail,
			String pwd) {
		super(name, lastName, mail, pwd);

		this.setStatus(false);
		
		//ajout role bseller
//		List<Role> listRoles=new ArrayList<Role>();
//		listRoles=super.getRoles();
//		listRoles.add(new Role("SELLER"));
//		this.setRoles(listRoles);

	}	

}
