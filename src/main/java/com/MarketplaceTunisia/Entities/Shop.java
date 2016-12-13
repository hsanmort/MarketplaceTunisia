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
		private Long id_shop;
		private String name_shop;
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
			return id_shop;
		}
		public void setId_shop(Long id_shop) {
			this.id_shop = id_shop;
		}
		public String getName_shop() {
			return name_shop;
		}
		public void setName_shop(String name_shop) {
			this.name_shop = name_shop;
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
			this.id_shop = id_shop;
			this.name_shop = name_shop;
			this.description = description;
			this.dateCreation = dateCreation;
			this.picture = picture;
		}
		public Shop() {
			super();
		}

}
