package com.MarketplaceTunisia.Entities;

import java.io.Serializable;

import javax.persistence.*;





@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_user",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class User implements Serializable {

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private static final long serialVersionUID = 1L;


	
}
