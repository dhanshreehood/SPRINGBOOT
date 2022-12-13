package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cybage.exception.RecordNotFoundException;
import com.cybage.model.Product;
import com.cybage.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;


	@GetMapping("/")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id){
		Product product =productService.getProductById(id);
		if(product ==null)
			throw new RecordNotFoundException("Product Not Found");
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}
	
	@GetMapping("name/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable String name){
		return new ResponseEntity<Product>(productService.getProductByName(name), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		boolean flag= productService.addProduct(product);
		if(flag)
			return new ResponseEntity<String>("Product added successfully",HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Some Error",HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		boolean flag= productService.deleteProduct(id);
		List<Product> productList = productService.getAllProduct();
		if(flag)
			return new ResponseEntity<String>("Product deleted successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Some Error",HttpStatus.BAD_REQUEST);

	}
	
	@PutMapping("/")
	public ResponseEntity<String> editProduct(@RequestBody Product product) {
		if(product ==null) {
			throw new RecordNotFoundException("Product Not updated");
		}
		productService.editProduct(product);
		return new ResponseEntity<String>("Product updated successfully",HttpStatus.OK);
	}
	
	
}
