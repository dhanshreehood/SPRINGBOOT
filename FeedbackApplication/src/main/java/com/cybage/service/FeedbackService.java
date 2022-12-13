package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Feedback;
import com.cybage.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public FeedbackService(FeedbackRepository feedbackRepository2) {
		this.feedbackRepository=feedbackRepository2;
	}

	//user adding feedback
	public Feedback addFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	public List<Feedback> getAllFeedback() {
		return feedbackRepository.findAll();
	}

	public Feedback getFeedbackById(int id) {
		return feedbackRepository.findById(id).orElse(null);
	}

	public void deleteFeedbackById(int id) {
		feedbackRepository.deleteById(id);;
	}

	public void deleteAllFeedback() {
		feedbackRepository.deleteAll();		
	}
	
	
}
