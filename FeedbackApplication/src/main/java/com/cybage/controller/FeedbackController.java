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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Feedback;
import com.cybage.service.FeedbackService;
@CrossOrigin("*")

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	
	//user giving feedback
	@PostMapping("/addFeedback")
	public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback){
		feedbackService.addFeedback(feedback);
		return new ResponseEntity<String>("Feedback added successfully", HttpStatus.CREATED);		
	}

	@GetMapping("/getAllFeedback")
	public ResponseEntity<List<Feedback>> getAllFeedback(){
		List<Feedback> feedbackList = feedbackService.getAllFeedback();
		return new ResponseEntity<List<Feedback>>(feedbackList, HttpStatus.OK);		
	}
	
	@GetMapping("/getFeedbackById/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable int id){
		Feedback feedback = feedbackService.getFeedbackById(id);
		return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);		
	}
	
	@DeleteMapping("/deleteFeedbackById/{id}")
	public ResponseEntity<String> deleteFeedbackById(@PathVariable int id){
		feedbackService.deleteFeedbackById(id);
		return new ResponseEntity<String>("Feedback deleted successfully.", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAllFeedback")
	public ResponseEntity<String> deleteFeedback(){
		feedbackService.deleteAllFeedback();
		return new ResponseEntity<String>("All Feedback Record deleted completely.", HttpStatus.OK);
	}

}
