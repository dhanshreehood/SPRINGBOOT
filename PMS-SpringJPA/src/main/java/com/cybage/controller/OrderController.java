package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Order;
import com.cybage.model.Product;
import com.cybage.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/add")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		Order order1 = orderService.addOrder(order);
		return new ResponseEntity<Order>(order1, HttpStatus.CREATED);
	}

	
	@GetMapping("/")
	public ResponseEntity<List<Order>> getOrders(){
		List<Order> orderList = orderService.fetchOrders();
		return new ResponseEntity<List<Order>>(orderList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable int id){
		Order order = orderService.getOrderById(id);
		return new ResponseEntity<Order>(order, HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable int id){
		orderService.deletOrderById(id);		
		return new ResponseEntity<String>("Record deleted successfully.",HttpStatus.OK);		
	}
	
	@PutMapping("/")
	private ResponseEntity<String> update(@RequestBody Order order) {
		orderService.update(order);
		return new ResponseEntity<String>("Order updated successfully.",HttpStatus.OK);		
		}
	/*
	@PutMapping("/{id}")
	private ResponseEntity<String> updateById(@PathVariable int id,@RequestBody Product product) {	
		productService.updateById(id,product);		
		return new ResponseEntity<String>("Product updated successfully.",HttpStatus.OK);		
		}
*/
}
