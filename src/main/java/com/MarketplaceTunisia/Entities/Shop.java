package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_shop")
public class Shop implements Serializable {

		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long idShop;
		private String nameShop;
		private String description;
		private Date dateCreation;
		private byte[] picture;
		
		public byte[] getPicture() {
			return picture;
		}
		public void setPicture(byte[] picture) {
			this.picture = picture;
		}
		public Long getId_shop() {
			return idShop;
		}
		public void setId_shop(Long id_shop) {
			this.idShop = id_shop;
		}
		public String getName_shop() {
			return nameShop;
		}
		public void setName_shop(String name_shop) {
			this.nameShop = name_shop;
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
		public Shop(Long id_shop, String name_shop, String description, Date dateCreation, byte[] picture) {
			super();
			this.idShop = id_shop;
			this.nameShop = name_shop;
			this.description = description;
			this.dateCreation = dateCreation;
			this.picture = picture;
		}
		public Shop() {
			super();
		}

}
