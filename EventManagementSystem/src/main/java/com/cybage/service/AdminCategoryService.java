package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.AdminBean;
import com.cybage.model.RegistrationBean;
import com.cybage.repository.AdminRepository;



@Service
public class AdminCategoryService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public AdminBean addCategory(AdminBean adminBean) 
	{
		return adminRepository.save(adminBean);
	}
	
	public List<AdminBean> getAllCategory()
	{
		return adminRepository.findAll();	
	}
	
	public AdminBean getCategoryById(int id)
	{
		return adminRepository.findById(id).orElse(null);
	}
	
	public void deleteCategory(int id)
	{
		adminRepository.deleteById(id);
	}
	
	public AdminBean updateCategory(int id, AdminBean adminBean)
	{
		AdminBean adminBean1 = adminRepository.findById(id).get();
			if(adminBean.getCategoryName()!=null)
				adminBean1.setCategoryName(adminBean.getCategoryName());
		return adminRepository.save(adminBean1);
	}
	
	//to find if category is unique or not
	public boolean checkCategory(String categoryName) {
		AdminBean userData = adminRepository.findByCategoryName(categoryName);
		
		if(userData != null) {
			return true;
		}
		else {
			return false;
		}
	}
	

}
