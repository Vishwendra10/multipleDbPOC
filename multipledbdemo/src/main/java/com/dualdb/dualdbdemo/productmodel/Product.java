package com.dualdb.dualdbdemo.productmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="PProduct")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int porductId;
	int userId;
	String productName;
	long price;

	public int getPorductId() {
		return porductId;
	}

	public void setPorductId(int porductId) {
		this.porductId = porductId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Product(int porductId, int userId, String productName, long price) {
		super();
		this.porductId = porductId;
		this.userId = userId;
		this.productName = productName;
		this.price = price;
	}

	public Product() {
		super();
	}
	
}
