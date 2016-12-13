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
	private int idUser;
	private String name;
	private String lastName;
	private String adress;
	private String mail;
	private String pwd;
	private char gender;
	private long tel;
	private byte[] picture;
	private String country;
	
	private static final long serialVersionUID = 1L;

	
	public User() {
		super();
	}

	public User(int idUser, String name, String lastName, String adress,
			String mail, String pwd, char gender, long tel, byte[] picture,
			String country) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.lastName = lastName;
		this.adress = adress;
		this.mail = mail;
		this.pwd = pwd;
		this.gender = gender;
		this.tel = tel;
		this.picture = picture;
		this.country = country;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	
}
