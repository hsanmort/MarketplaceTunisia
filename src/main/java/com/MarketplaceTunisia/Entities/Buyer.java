package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("BU")
@Table(name = "t_buyer")
public class Buyer extends User implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private ArrayList<String> hobbies=new ArrayList<String>();
		
		@OneToMany(mappedBy="buyer",cascade=CascadeType.REMOVE)
		private List<Complaint> complaints;
		
		@OneToMany(mappedBy="buyer")
		private List<Order> orders;

		public ArrayList<String> getHobbies() {
			return hobbies;
		}

		public void setHobbies(ArrayList<String> hobbies) {
			this.hobbies = hobbies;
		}

		@JsonIgnore
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


		public Buyer(String name, String lastName, String mail,
				String pwd, char gender, long tel, byte[] picture,
				Adress adress, ArrayList<String> hobbies,
				List<Complaint> complaints, List<Order> orders) {
			super(name, lastName, mail, pwd, gender, tel, picture,
					adress);
			this.hobbies = hobbies;
			this.complaints = complaints;
			this.orders = orders;
			this.setStatus(false);
			
			//ajout role buyer 
//			List<Role> listRoles=new ArrayList<Role>();
//			listRoles=super.getRoles();
//			listRoles.add(new Role("BUYER"));
//			this.setRoles(listRoles);

		}

		public Buyer() {
			super();
			//ajout role buyer 
//			List<Role> listRoles=new ArrayList<Role>();
//			listRoles=super.getRoles();
//			listRoles.add(new Role("BUYER"));
//			this.setRoles(listRoles);
		}

		public Buyer(ArrayList<String> hobbies, List<Complaint> complaints,
				List<Order> orders) {
			super();
			this.hobbies = hobbies;
			this.complaints = complaints;
			this.orders = orders;
			this.setStatus(false);
			
			//ajout role buyer 
//			List<Role> listRoles=new ArrayList<Role>();
//			listRoles=super.getRoles();
//			listRoles.add(new Role("BUYER"));
//			this.setRoles(listRoles);
		
		}

	
		public Buyer(String name, String lastName, String mail,
				String pwd) {
			super(name, lastName, mail, pwd);

			this.setStatus(false);
			
			//ajout role buyer 
//			List<Role> listRoles=new ArrayList<Role>();
//			listRoles=this.getRoles();
//			Role r=new Role("BUYER");
//			listRoles.add(r);
//			this.setRoles(listRoles);

		}	
}
