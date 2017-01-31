package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	public Product(int idProduct, String nameProduct, String description, double price, Date dateAdd, int qte,
			boolean discount, byte[] picture, double reviews, Shop shop, List<Order> orders, Category category,
			List<ShoppingCart> shoppingCarts) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.description = description;
		this.price = price;
		this.dateAdd = dateAdd;
		Qte = qte;
		this.discount = discount;
		this.picture = picture;
		Reviews = reviews;
		this.shop = shop;
		this.orders = orders;
		this.category = category;
		this.shoppingCarts = shoppingCarts;
	}

	private String description;
	private double price;
	private Date dateAdd;
	private int Qte;
	private boolean discount;
	private byte[] picture;
	private double Reviews;
	//@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_shop")
	private Shop shop;
	@JsonIgnore
	@ManyToMany(mappedBy="products")
	private List<Order> orders;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;
	@JsonIgnore
	@ManyToMany(mappedBy="products")
	private List<ShoppingCart> shoppingCarts;

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
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

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	public Product() {
		super();
	}

	public Product(String nameProduct, String description,
			double price, Date dateAdd, int qte, boolean discount,
			byte[] picture, double reviews, Shop shop, List<Order> orders,
			Category category) {
		super();
		this.nameProduct = nameProduct;
		this.description = description;
		this.price = price;
		this.dateAdd = dateAdd;
		Qte = qte;
		this.discount = discount;
		this.picture = picture;
		Reviews = reviews;
		this.shop = shop;
		this.orders = orders;
		this.category = category;
	}
	

}
