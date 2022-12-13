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

import com.cybage.exception.InvalidInputException;
import com.cybage.model.AdminBean;
import com.cybage.service.AdminCategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")

public class AdminCategoryController {
	
	@Autowired
	private AdminCategoryService adminCategoryService;
	
	@PostMapping("/")
	public ResponseEntity<String> addCategory(@RequestBody AdminBean adminBean)
	{
		String categoryName = adminBean.getCategoryName();

		boolean verifyIfCategoryExists = adminCategoryService.checkCategory(categoryName);
		
		if(!verifyIfCategoryExists) {	
		AdminBean adminBean1 = adminCategoryService.addCategory(adminBean);
		return new ResponseEntity<String>("Category Added Successfully!!",HttpStatus.CREATED);
		}
		else {
			throw new InvalidInputException("Category already exists!");		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AdminBean>> getAllCategory()
	{
		List<AdminBean> categoryList = adminCategoryService.getAllCategory();
		return new ResponseEntity<List<AdminBean>>(categoryList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AdminBean> getCategory(@PathVariable int id)
	{
		AdminBean adminBean1 = adminCategoryService.getCategoryById(id);
		return new ResponseEntity<AdminBean>(adminBean1,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id)
	{
		adminCategoryService.deleteCategory(id);
		return new ResponseEntity<String>("Category Deleted Successfully!!",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable int id, @RequestBody AdminBean adminBean)
	{
		adminCategoryService.updateCategory(id,adminBean);
		return new ResponseEntity<String>("Category Updated Successfully",HttpStatus.CREATED);
	}

}