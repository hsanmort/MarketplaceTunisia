package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_complaint")
public class Complaint implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComplaint;
	private String description;
	private Date dateComplaint;
	
	@ManyToOne
	@JoinColumn(name="id_buyer")
	private Buyer buyer;
	
	@ManyToOne
	@JoinColumn(name="id_seller")
	private Seller seller;

	public int getIdComplaint() {
		return idComplaint;
	}

	public void setIdComplaint(int idComplaint) {
		this.idComplaint = idComplaint;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateComplaint() {
		return dateComplaint;
	}

	public void setDateComplaint(Date dateComplaint) {
		this.dateComplaint = dateComplaint;
	}

	//@JsonIgnore
	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	//@JsonIgnore
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Complaint(String description, Date dateComplaint,
			Buyer buyer, Seller seller) {
		super();
		this.description = description;
		this.dateComplaint = dateComplaint;
		this.buyer = buyer;
		this.seller = seller;
	}

	public Complaint() {
		super();
	}
	
}
