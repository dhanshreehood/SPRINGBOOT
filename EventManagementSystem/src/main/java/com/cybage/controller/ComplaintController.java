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

import com.cybage.model.ComplaintBean;
import com.cybage.model.EventBean;
import com.cybage.service.ComplaintService;

@CrossOrigin("*")
@RestController
@RequestMapping("/complaint")
public class ComplaintController {

	@Autowired
	private ComplaintService complaintService;
	
	@PostMapping("/addComplaint")
	public ResponseEntity<String> addComplaint(@RequestBody ComplaintBean complaintBean)
	{
		ComplaintBean complaintBean2 = complaintService.addComplaint(complaintBean);
		return new ResponseEntity<String>("Complaint Added Successfully!!",HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllComplaints")
	public ResponseEntity<List<ComplaintBean>> getAllComplaints()
	{
		List<ComplaintBean> complaintList = complaintService.getAllComplaints();
		return new ResponseEntity<List<ComplaintBean>>(complaintList,HttpStatus.OK);
	} 
	
	@GetMapping("/getComplaintById/{id}")
	public ResponseEntity<ComplaintBean> getComplaintById(@PathVariable int id)
	{
		ComplaintBean complaintBean2 = complaintService.getComplaintById(id);
		return new ResponseEntity<ComplaintBean>(complaintBean2,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteComplaintById/{id}")
	public ResponseEntity<String> deleteComplaintById(@PathVariable int id)
	{
		complaintService.deleteComplaintById(id);
		return new ResponseEntity<String>("Commplaint Deleted Successfully!!",HttpStatus.OK);
	}
	
	@PutMapping("/updateComplaint/{id}")
	public ResponseEntity<String> updateComplaint(@PathVariable int id, @RequestBody ComplaintBean complaintBean)
	{
		complaintService.updateComplaint(id,complaintBean);
		return new ResponseEntity<String>("Complaint Updated Successfully",HttpStatus.CREATED);
	}
	
	//get Event List by id
	@GetMapping("/getComplaintByUserId/{id}")
	public ResponseEntity<List<ComplaintBean>> getComplaintByUserId(@PathVariable int id)
	{
		List<ComplaintBean> eventList = complaintService.getComplaintByUserId(id);
		return new ResponseEntity<List<ComplaintBean>>(eventList,HttpStatus.OK);
	}
}
