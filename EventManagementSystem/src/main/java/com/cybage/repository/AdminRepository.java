package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;import com.cybage.model.AdminBean;
import com.cybage.model.RegistrationBean;

@Repository
public interface AdminRepository extends JpaRepository<AdminBean, Integer> {
	
	AdminBean findByCategoryName(String categoryName);

}
