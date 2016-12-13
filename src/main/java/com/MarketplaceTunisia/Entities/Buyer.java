package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("BU")
@Table(name = "t_buyer")
public class Buyer extends User implements Serializable {

		
		

		private static final long serialVersionUID = 1L;
		private List hobbies;
		public List getHobbies() {
			return hobbies;
		}
		public void setHobbies(List hobbies) {
			this.hobbies = hobbies;
		}
		public Buyer(List hobbies) {
			super();
			this.hobbies = hobbies;
		}
		public Buyer() {
			super();
		}
		

}
