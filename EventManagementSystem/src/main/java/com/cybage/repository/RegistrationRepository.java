package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.model.RegistrationBean;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationBean, Integer> {

	@Query("SELECT u FROM RegistrationBean u WHERE u.email = ?1")
	public RegistrationBean findByEmail(String email);

	@Query("SELECT u FROM RegistrationBean u WHERE u.verificationStatus = ?1")
	public RegistrationBean findByVerificationStatus(String status);
	
	@Query("FROM RegistrationBean WHERE role = 'ORGANIZER' ")
	public List<RegistrationBean> getByOrganizer();
	
	@Query("FROM RegistrationBean WHERE role = 'USER' ")
	public List<RegistrationBean> getByUser();
	
}