package com.cybage.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

public class Feedback {

	@Id
	@GeneratedValue
	@Column(name="feedbackId", unique = true, nullable = false)
	private int feedbackId;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="feedback")
	private String feedback;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}