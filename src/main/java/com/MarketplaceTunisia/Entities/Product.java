package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_product")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;
	private String nameProduct;
	private String description;
	private double price;
	private Date dateAdd;
	private int Qte;
	private boolean discount;
	private byte[] picture;
	private double Reviews;
	
	public int getId_product() {
		return idProduct;
	}
	public void setId_product(int id_product) {
		this.idProduct = id_product;
	}
	public String getName_product() {
		return nameProduct;
	}
	public void setName_product(String name_product) {
		this.nameProduct = name_product;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDateAdd() {
		return dateAdd;
	}
	public void setDateAdd(Date dateAdd) {
		this.dateAdd = dateAdd;
	}
	public int getQte() {
		return Qte;
	}
	public void setQte(int qte) {
		Qte = qte;
	}
	public boolean isDiscount() {
		return discount;
	}
	public void setDiscount(boolean discount) {
		this.discount = discount;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public double getReviews() {
		return Reviews;
	}
	public void setReviews(double reviews) {
		Reviews = reviews;
	}
	public Product(int id_product, String name_product, String description, double price, Date dateAdd, int qte,
			boolean discount, byte[] picture, double reviews) {
		super();
		this.idProduct = id_product;
		this.nameProduct = name_product;
		this.description = description;
		this.price = price;
		this.dateAdd = dateAdd;
		Qte = qte;
		this.discount = discount;
		this.picture = picture;
		Reviews = reviews;
	}
	public Product() {
		super();
	}
	
}
