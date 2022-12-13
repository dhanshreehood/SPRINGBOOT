package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.model.ComplaintBean;

@Repository
public interface ComplaintRepository extends JpaRepository<ComplaintBean, Integer>{

//	select * from complaint where user_complaint_id = 1;
	
//	get complaint list by user id
	@Query(value = "select * from complaint where user_complaint_id = ?1 ",nativeQuery=true)
	public List<ComplaintBean> getComplaintByUserId(int id);
	
}