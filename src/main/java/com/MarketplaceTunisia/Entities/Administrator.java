package com.MarketplaceTunisia.Entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("AD")
@Table(name="t_admin")
public class Administrator extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrator(String name, String lastName, String mail,
			String pwd) {
		super(name, lastName, mail, pwd);
	}

	public Administrator(){
		super();
	}
}
