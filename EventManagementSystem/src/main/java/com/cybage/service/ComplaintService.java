package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.ComplaintBean;
import com.cybage.model.EventBean;
import com.cybage.repository.ComplaintRepository;

@Service
public class ComplaintService {
	
	@Autowired
	ComplaintRepository complaintRepository;
	
	public ComplaintBean addComplaint(ComplaintBean complaintBean)
	{
		return complaintRepository.save(complaintBean);
	}

	public List<ComplaintBean> getAllComplaints()
	{
		return complaintRepository.findAll();
	}
	
	public ComplaintBean getComplaintById(int id) 
	{
		return complaintRepository.findById(id).orElse(null);
	}
	
	public void deleteComplaintById(int id)
	{
		complaintRepository.deleteById(id);
	}
	
	public ComplaintBean updateComplaint(int id, ComplaintBean complaintBean)
	{
		ComplaintBean complaintBean1 = complaintRepository.findById(id).get();
		
			if(complaintBean.getComplaintId()!=0)
				complaintBean1.getComplaintId();
					
			if(complaintBean.getComplaintDiscription()!=null)
				complaintBean1.setComplaintDiscription(complaintBean.getComplaintDiscription());
			
			if(complaintBean.getComplaintStatus()!=null)
				complaintBean1.setComplaintStatus(complaintBean.getComplaintStatus());

		return complaintRepository.save(complaintBean1);
	}
	
	//get complaint list by id
	public List<ComplaintBean> getComplaintByUserId(int id){
		return complaintRepository.getComplaintByUserId(id);
	}
	
}