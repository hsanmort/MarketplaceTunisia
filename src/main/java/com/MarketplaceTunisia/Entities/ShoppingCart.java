package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="t_shoppingCart")
public class ShoppingCart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCart;
	private int qte;
	
	
	@ManyToMany
	@JoinTable(name="cart_list",
	joinColumns=@JoinColumn(name="id_cart",referencedColumnName="idCart"),
	inverseJoinColumns=@JoinColumn(name="id_product",referencedColumnName="idProduct"))
	private List<Product> products;


	public int getIdCart() {
		return idCart;
	}


	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public ShoppingCart( int qte, List<Product> products) {
		super();
		this.qte = qte;
		this.products = products;
	}


	public ShoppingCart() {
		super();
	}
	

}
