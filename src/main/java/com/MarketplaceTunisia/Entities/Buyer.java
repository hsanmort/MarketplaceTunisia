package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("BU")
@Table(name = "t_buyer")
public class Buyer extends User implements Serializable {

		
		

		private static final long serialVersionUID = 1L;
		
		private ArrayList<String> hobbies=new ArrayList<String>();
		
		@OneToMany(mappedBy="buyer")
		private List<Complaint> complaints;
		
		@OneToMany(mappedBy="buyer")
		private List<Order> orders;

		

		public ArrayList<String> getHobbies() {
			return hobbies;
		}

		public void setHobbies(ArrayList<String> hobbies) {
			this.hobbies = hobbies;
		}

		public List<Complaint> getComplaints() {
			return complaints;
		}

		public void setComplaints(List<Complaint> complaints) {
			this.complaints = complaints;
		}

		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}

		

	
		public Buyer(int idUser, String name, String lastName, String mail,
				String pwd, char gender, long tel, byte[] picture,
				Adress adress, ArrayList<String> hobbies,
				List<Complaint> complaints, List<Order> orders) {
			super(idUser, name, lastName, mail, pwd, gender, tel, picture,
					adress);
			this.hobbies = hobbies;
			this.complaints = complaints;
			this.orders = orders;
			this.setStatus(false);

		}

		public Buyer() {
			super();
		}

		public Buyer(ArrayList<String> hobbies, List<Complaint> complaints,
				List<Order> orders) {
			super();
			this.hobbies = hobbies;
			this.complaints = complaints;
			this.orders = orders;
			this.setStatus(false);

		}

	
		
}
