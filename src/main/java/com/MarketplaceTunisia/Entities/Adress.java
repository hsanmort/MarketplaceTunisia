package com.MarketplaceTunisia.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_adress")
public class Adress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdress;
	private String street;
	private int postalCode;
	private String city;
	private String country;
	public Adress() {
		super();
	}
	public Adress(int idAdress, String street, int postalCode, String city,
			String country) {
		super();
		this.idAdress = idAdress;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}
	public int getIdAdress() {
		return idAdress;
	}
	public void setIdAdress(int idAdress) {
		this.idAdress = idAdress;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
