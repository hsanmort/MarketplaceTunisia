package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.MarketplaceTunisia.DAO.RoleRepository;






@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_user",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;
	private String name;
	private String lastName;
	private String mail;
	private String pwd;
	private char gender;
	private long tel;
	private byte[] picture;
	private Boolean status;
	
	@OneToOne
	@JoinColumn(name = "id_adress")
	private Adress adress;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="USERS_ROLES",
	joinColumns=@JoinColumn(name="user_id_user",referencedColumnName="idUser"),
	inverseJoinColumns=@JoinColumn(name="roles_role",referencedColumnName="role"))
	private List<Role> roles;
	
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User(String name, String lastName, String mail,
			String pwd, char gender, long tel, byte[] picture,
			Adress adress) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
		this.pwd = pwd;
		this.gender = gender;
		this.tel = tel;
		this.picture = picture;
		this.status = true;
		this.adress = adress;
		this.roles=new ArrayList<Role>();
		//this.roles.add(new Role("INVITE"));
	}

	public User() {
		super();
		this.roles=new ArrayList<Role>();
		//this.roles.add(new Role("INVITE"));
	}

	public User(String name, String lastName, String mail, String pwd) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
		this.pwd = pwd;
		this.roles=new ArrayList<Role>();
		//this.roles.add(new Role("INVITE"));
	}
	
	


	

	
}
