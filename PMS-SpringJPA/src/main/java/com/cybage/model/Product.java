package com.cybage.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//add lombok path in Users/dhanshreeh/.m2/lombok/.1.3.8 version - in eclipse extracted files.
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="product_info")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="product_id")
	private int productId;

	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private  int price;

	@OneToMany(mappedBy="product") //one product associated to the many orders
	@JsonIgnore
	private List<Order> orderList;
	
/*	// one order can be associated to the many products
	@ManyToOne //many values of product will be associated to the one value of order
	private Order order;
	*/
	
/*	
	@OneToOne(mappedBy="product")// it will add foreign key constraint in order table; if you add Order it will get added to the product table 
	private Order order;
*/
	/*	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getProductId() {
		return productId;
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

	public Product(int productId, String productName, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public Product() {
		
	}
	*/
}
