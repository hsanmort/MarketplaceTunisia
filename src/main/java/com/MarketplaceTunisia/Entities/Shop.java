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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_shop")
public class Shop implements Serializable {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long idShop;
		public Shop(Long idShop) {
			super();
			this.idShop = idShop;
		}

		private String nameShop;
		private String description;
		private Date dateCreation;
		private byte[] picture;
		@JsonIgnore
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="id_seller")
		private Seller seller;
		@JsonIgnore
		@OneToMany(mappedBy="shop")
		private List<Product> products;

		public Long getIdShop() {
			return idShop;
		}

		public void setIdShop(Long idShop) {
			this.idShop = idShop;
		}

		public String getNameShop() {
			return nameShop;
		}

		public void setNameShop(String nameShop) {
			this.nameShop = nameShop;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getDateCreation() {
			return dateCreation;
		}

		public void setDateCreation(Date dateCreation) {
			this.dateCreation = dateCreation;
		}

		public byte[] getPicture() {
			return picture;
		}

		public void setPicture(byte[] picture) {
			this.picture = picture;
		}

		public Seller getSeller() {
			return seller;
		}

		public void setSeller(Seller seller) {
			this.seller = seller;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		public Shop() {
			super();
		}

		public Shop(String nameShop, String description,
				Date dateCreation, byte[] picture, Seller seller,
				List<Product> products) {
			super();
			this.nameShop = nameShop;
			this.description = description;
			this.dateCreation = dateCreation;
			this.picture = picture;
			this.seller = seller;
			this.products = products;
		}

	
		
		

}
