package com.MarketplaceTunisia.Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order {

	private int idOrder;
	private Date dateO;
	private double price;
	private Date dateDelev;
	private int productnb;
	
	
	public Order() {
		super();
	}
	
	public Order(int idOrder, Date dateO, double price, Date dateDelev,
			int productnb) {
		super();
		this.idOrder = idOrder;
		this.dateO = dateO;
		this.price = price;
		this.dateDelev = dateDelev;
		this.productnb = productnb;
	}

	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public Date getDateO() {
		return dateO;
	}
	public void setDateO(Date dateO) {
		this.dateO = dateO;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDateDelev() {
		return dateDelev;
	}
	public void setDateDelev(Date dateDelev) {
		this.dateDelev = dateDelev;
	}
	public int getProductnb() {
		return productnb;
	}
	public void setProductnb(int productnb) {
		this.productnb = productnb;
	}
	

}
