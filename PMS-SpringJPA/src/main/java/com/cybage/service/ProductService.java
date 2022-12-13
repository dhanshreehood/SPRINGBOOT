package com.cybage.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cybage.model.Product;
import com.cybage.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

//	//sorting in descending order
//	public List<Product> getAllProductByPageable(Product product) {
//		//Pageable pageable=PageRequest.of(0, 2);
//		//return productRepository.findAll(pageable).toList();
//		return productRepository.findAll(Sort.by(Direction.DESC, "price"));
//	}
	
	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}
	

	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}

	public Product updateById(int id, Product product) {
		Product product1=productRepository.findById(id).get();
		if(product.getProductName()!=null)
		  product1.setProductName(product.getProductName());
		if(product.getPrice()!=0)
		product1.setPrice(product.getPrice());
		return productRepository.save(product1);
	}

	public void update(Product product) {
		productRepository.save(product);
	}

	public List<Product> findByProductName(String name) {
		return productRepository.findByProductName(name);
	}

	public List<Product> findByProductPrice(int price) {
		return productRepository.findByPrice(price);
	}

	public List<Product> findByPriceBetween(int price, int price2) {
		return productRepository.findByPriceBetween(price, price2);
	}

	public List<Product> getByName(String name, int price) {
		return productRepository.getByName(name, price);
	}
}
