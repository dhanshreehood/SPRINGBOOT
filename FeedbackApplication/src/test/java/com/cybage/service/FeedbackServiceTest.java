package com.cybage.service;

import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.cybage.repository.FeedbackRepository;

@ExtendWith(MockitoExtension.class)
public class FeedbackServiceTest {
	
	@Mock
	private FeedbackRepository feedbackRepository;
	
	@Autowired
	private FeedbackService feedbackService;
	
	@BeforeEach
	void setUp() {
		this.feedbackService = new FeedbackService(this.feedbackRepository);
	}
	
	@Test
	void getAllFeedbackTest() {
		feedbackService.getAllFeedback();
		verify(feedbackRepository).findAll();
	}	
}
