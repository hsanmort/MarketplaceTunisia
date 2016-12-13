package com.MarketplaceTunisia.Entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.MarketplaceTunisia.Entities.User;

@Entity
@DiscriminatorValue("SE")
@Table(name = "t_seller")
public class Seller extends User implements Serializable {

	
	

	
	private static final long serialVersionUID = 1L;
	
	private String company_name;

	private int company_id;

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getCompany_id() {
		return company_id;
	}

	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}

	public Seller(String company_name, int company_id) {
		super();
		this.company_name = company_name;
		this.company_id = company_id;
	}

	public Seller() {
		super();
	}
	

}
