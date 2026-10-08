package com.association_mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {
	@Id
	private int lid;
	@Column(name = "Laptop_name", nullable = false, unique = true)
	private String lname;

	Laptop(int lid, String lname) {
		this.lid = lid;
		this.lname = lname;
	}

	public Laptop() {
	}

	public int getId() {
		return lid;
	}

	public void setId(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + "]";
	}

}
