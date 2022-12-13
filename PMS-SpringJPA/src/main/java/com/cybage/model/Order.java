package com.cybage.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="order_info")
public class Order {
	@Id
	@GeneratedValue
	private int orderId;

	//u may provide column for diff name or it will take the variable name given here
	
	@ManyToOne
	private Product product;

	/*@OneToMany(mappedBy="order")//one order will be associated to the Many Product. one product can have multiple product. 
	private List<Product> productList;
	*/
	
/*	@OneToOne //one order will have one //unidirectional
	@JoinColumn(name="product_id") //to join column
	private Product product;
*/
	
/*
	public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
@Override
public String toString() {
	return "Order [orderId=" + orderId + ", product=" + product + "]";
}
*/

}


