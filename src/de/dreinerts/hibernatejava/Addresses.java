package de.dreinerts.hibernatejava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Addresses {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="lastname")
	private String strLastname;
	@Column(name="firstname")
	private String strFirstname;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStrLastname() {
		return strLastname;
	}

	public void setStrLastname(String strLastname) {
		this.strLastname = strLastname;
	}

	public String getStrFirstname() {
		return strFirstname;
	}

	public void setStrFirstname(String strFirstname) {
		this.strFirstname = strFirstname;
	}
	
	
	
}
