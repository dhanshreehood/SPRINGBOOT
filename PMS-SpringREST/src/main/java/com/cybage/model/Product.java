package com.cybage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@AllArgsConstructor //with list it will not work
// @Getter
// @Setter
// @ToString
public class Product {
	private int productId;
	private String productName;
	private int price;
	public int getProductId() {
		return productId;
	}
	
	
	public Product() {

	}


	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
	public Product(int productId, String productName, int price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	public String getProductByName() {
		// TODO Auto-generated method stub
		return null;
	}


}
