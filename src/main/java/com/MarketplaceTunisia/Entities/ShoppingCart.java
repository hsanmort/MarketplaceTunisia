package com.MarketplaceTunisia.Entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	public ShoppingCart(int idCart, int qte) {
		super();
		this.idCart = idCart;
		this.qte = qte;
	}
	public ShoppingCart() {
		super();
	}
}
