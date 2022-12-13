package com.cybage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.modal.Product;
import com.cybage.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	// private Object Product;

	// @RequestMapping("/hello") //Can use at class level

	@GetMapping("/hello") // Can use at method level
	public String sayHello() {
		return "greet"; // represents name of the view and will search it in template
	}

	@RequestMapping("/welcome")

	public ModelAndView welcome(Model model) // model is the data you want to display
	{
		// model.addAttribute("name","Nidhi");
		return new ModelAndView("welcome", "name", "Anish");
	}

	@GetMapping("/getAllProducts")
	public ModelAndView getAllProduct() {
		List<Product> productList = productService.getAllProduct();
		// System.out.println();
		return new ModelAndView("displayProduct", "products", productList);
	}

	@GetMapping("/getProduct/{id}")
	public ModelAndView getProduct(@PathVariable int id) {
		Product product = productService.getProductById(id);
		return new ModelAndView("viewproductId", "product", product);
	}

	@GetMapping("/addProductForm")
	public ModelAndView showAddProductForm() {
		Product product = new Product();
		return new ModelAndView("addProduct", "product", product);
	}

	@PostMapping("/addProduct")
	public ModelAndView addProduct(@Valid @ModelAttribute Product product, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("addProduct", "product", product);
		}
		productService.addProduct(product);
		List<Product> productList = productService.getAllProduct();
		return new ModelAndView("displayProduct", "products", productList);
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		List<Product> productList = productService.getAllProduct();
		return new ModelAndView("displayProduct", "products", productList);
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView updateProduct(@PathVariable int id) {
		Product product = productService.getProductById(id);
		return new ModelAndView("editProduct", "product", product);
		
	}
	@PostMapping("/edit")
	public ModelAndView update(Product product){
		productService.editProduct(product);
		List<Product> productList = productService.getAllProduct();
		return new ModelAndView("displayProduct", "products", productList);
	}
		
}
