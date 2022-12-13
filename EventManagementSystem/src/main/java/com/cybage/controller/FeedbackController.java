package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.model.Feedback;

@CrossOrigin("*")

@RestController
@RequestMapping("/mainSystemFeedback")
public class FeedbackController {

	@Autowired
	private RestTemplate restTemplate;
	
	private String baseUrl="http://localhost:8081/feedback";

	@PostMapping("/addFeedback")
	public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback)
	{
		return restTemplate.postForEntity(baseUrl + "/addFeedback", feedback, String.class); 
	}
	
	@GetMapping("/getAllFeedback")
	public ResponseEntity<Feedback[]> getAllFeedback()
	{
		return restTemplate.getForEntity(baseUrl + "/getAllFeedback", Feedback[].class);
	}
	
	@GetMapping("/getFeedbackById/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable int id)
	{
		return restTemplate.getForEntity(baseUrl + "/getFeedbackById/{id}", Feedback.class);
	}
}