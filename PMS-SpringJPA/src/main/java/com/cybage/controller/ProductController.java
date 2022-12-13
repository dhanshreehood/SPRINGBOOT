package com.cybage.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Product;
import com.cybage.service.ProductService;

//@CrossOrigin("http://localhost:4200/demo") //adding angular link of demo data component
@CrossOrigin("*") //adding angular link of demo data component

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired	
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		productService.addProduct(product);
		return new ResponseEntity<String>("Record added successfully", HttpStatus.CREATED);		
	}
	
//	//sorting product in descending order
//	@GetMapping("/pageable")
//	public ResponseEntity<List<Product>> getAllProductByPageable(@RequestBody Product product){
//		List<Product> productList = productService.getAllProductByPageable(product);		
//		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);		
//	}
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> productList = productService.getAllProduct();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Product product = productService.getProductById(id);
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);		
	}
		
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable int id){
		productService.deleteProductById(id);		
		return new ResponseEntity<String>("Record deleted successfully.",HttpStatus.OK);		
	}
	
	@PutMapping("/")
	private ResponseEntity<String> update(@RequestBody Product product) {
		productService.update(product);
		return new ResponseEntity<String>("Product updated successfully.",HttpStatus.OK);		
		}

	@PutMapping("/put/{id}")
	private ResponseEntity<String> updateById(@PathVariable int id,@RequestBody Product product) {	
		productService.updateById(id,product);		
		return new ResponseEntity<String>("Product updated successfully.",HttpStatus.OK);		
		}
	
	@GetMapping("name/{name}")
	public ResponseEntity<List<Product>> findByProductName(@PathVariable String name){
		List<Product> productList = productService.findByProductName(name);		
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);		
	}
	
	@GetMapping("price/{price}")
	public ResponseEntity<List<Product>> findByProductPrice(@PathVariable int price){
		List<Product> productList = productService.findByProductPrice(price);		
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);		
	}
	
	@GetMapping("pricebetween/{price}/{price2}")
	public ResponseEntity<List<Product>> findByPriceBetween(@PathVariable int price,@PathVariable int price2){
		List<Product> productList = productService.findByPriceBetween(price,price2);		
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);		
	}
	
	@GetMapping("getname/{name}/{price}")
	public ResponseEntity<List<Product>> getByName(@PathVariable String name, @PathVariable int price){
		List<Product> productList = productService.getByName(name, price);		
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);		
	}
	}