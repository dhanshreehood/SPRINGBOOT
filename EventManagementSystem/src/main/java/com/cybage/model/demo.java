package com.cybage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Value;
@Entity
@Table
public class demo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookingId")
	private int bookingId;
	
	@Column(name="bookingStatus")
	@Value("${some.key: PENDING}")
	private String bookingStatus;
}
	
	