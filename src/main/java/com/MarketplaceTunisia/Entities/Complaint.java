package com.MarketplaceTunisia.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_complaint")
public class Complaint implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComplaint;
	private String description;
	private Date dateComplaint;
	public int getIdComplaint() {
		return idComplaint;
	}
	public void setIdComplaint(int idComplaint) {
		this.idComplaint = idComplaint;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateComplaint() {
		return dateComplaint;
	}
	public void setDateComplaint(Date dateComplaint) {
		this.dateComplaint = dateComplaint;
	}
	public Complaint(int idComplaint, String description, Date dateComplaint) {
		super();
		this.idComplaint = idComplaint;
		this.description = description;
		this.dateComplaint = dateComplaint;
	}
	public Complaint() {
		super();
	}
	

}
