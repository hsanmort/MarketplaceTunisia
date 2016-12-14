package com.MarketplaceTunisia.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_order")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrder;
	private Date dateO;
	private double price;
	private Date dateDelev;
	private int productnb;
	
	@ManyToMany
	@JoinTable(name="order_list",
	joinColumns=@JoinColumn(name="id_order",referencedColumnName="idOrder"),
	inverseJoinColumns=@JoinColumn(name="id_product",referencedColumnName="idProduct"))
	private List<Product> products;
	
	@ManyToOne
	@JoinColumn(name = "id_adress")
	private Adress adress;
	
	@ManyToOne
	@JoinColumn(name = "id_buyer")
	private Buyer buyer;

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Order(Date dateO, double price, Date dateDelev,
			int productnb, List<Product> products, Adress adress, Buyer buyer) {
		super();
		this.dateO = dateO;
		this.price = price;
		this.dateDelev = dateDelev;
		this.productnb = productnb;
		this.products = products;
		this.adress = adress;
		this.buyer = buyer;
	}

	public Order() {
		super();
	}
	


}
