package com.cybage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cybage.modal.Product;

@Service
public class ProductService {

	private List<Product> productList = new ArrayList<>();

	public ProductService() {
		productList.add(new Product(1001, "Mobile", 60000));
		productList.add(new Product(1002, "Sneakers", 80000));
		productList.add(new Product(1003, "Laptop", 50000));
		productList.add(new Product(1004, "Headphones", 6000));

	}

	public List<Product> getAllProduct() {
		return productList;
	}

	public Product getProductById(int id) {

		Product product1 = productList.stream().filter(product -> product.getProductId() == id).findFirst().get();
		// traverse
		// the
		// list
		// and
		// check
		// for
		// the
		// product

		return product1;
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	public void deleteProduct(int id) {
		Product productdel = getProductById(id);
		productList.remove(productdel);
	}

	public void editProduct(Product product) {
		Product productedit = getProductById(product.getProductId());
		int prodid = productList.indexOf(productedit);
		productList.set(prodid, product);
	}
}