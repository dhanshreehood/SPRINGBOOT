package com.cybage.modal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Product {

	@Min(1000)
	@Max(10000)
	private int productId;

	@NotEmpty
	@Size(min = 3, max = 30, message = "Min no of characters must be 3")
	private String ProductName;

	private int Price;

	public Product() {

	}

	public Product(int productId, String productName, int price) {
		super();
		this.productId = productId;
		this.ProductName = productName;
		this.Price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", ProductName=" + ProductName + ", Price=" + Price
				+ ", getProductId()=" + getProductId() + ", getProductName()=" + getProductName() + ", getPrice()="
				+ getPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
