package com.MarketplaceTunisia.Entities;

import java.io.Serializable;

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

}
