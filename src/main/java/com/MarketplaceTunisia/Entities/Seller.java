package com.MarketplaceTunisia.Entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.Table;

import com.MarketplaceTunisia.Entities.User;

@Entity
@DiscriminatorValue("SE")
@Table(name = "t_seller")
public class Seller extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String companyName;

	private int companyId;

	public String getCompany_name() {
		return companyName;
	}

	public void setCompany_name(String company_name) {
		this.companyName = company_name;
	}

	public int getCompany_id() {
		return companyId;
	}

	public void setCompany_id(int company_id) {
		this.companyId = company_id;
	}

	public Seller(String company_name, int company_id) {
		super();
		this.companyName = company_name;
		this.companyId = company_id;
	}

	public Seller() {
		super();
	}
	

}
