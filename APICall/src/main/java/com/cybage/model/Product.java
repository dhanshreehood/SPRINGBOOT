package com.cybage.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter 
@Setter
@ToString
public class Product {

	private int productId;
	private String productname;
	private int price;
	
}
