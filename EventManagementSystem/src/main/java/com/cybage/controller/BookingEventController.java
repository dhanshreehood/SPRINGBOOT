package com.cybage.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.BookingEvent;
import com.cybage.model.EventBean;
import com.cybage.model.RegistrationBean;
import com.cybage.service.BookingEventService;

@CrossOrigin("*")
@RestController
@RequestMapping("/booking")
public class BookingEventController {
	
	@Autowired
	private BookingEventService bookingEventService;
	
	@PostMapping("/addBooking")
	public ResponseEntity<String> addBooking(@RequestBody BookingEvent bookingEvent)
	{
		BookingEvent bookingEventService1 = bookingEventService.addBooking(bookingEvent);
		return new ResponseEntity<String>("Event Booked Successfully!!",HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllBooking")
	public ResponseEntity<List<BookingEvent>> getAllBooking()
	{
		List<BookingEvent> eventList = bookingEventService.getAllBooking();
		return new ResponseEntity<List<BookingEvent>>(eventList,HttpStatus.OK);
	}
	
	@GetMapping("/getBookingById/{id}")
	public ResponseEntity<BookingEvent> getBookingById(@PathVariable int id)
	{
		BookingEvent bookingService = bookingEventService.getBookingById(id);
		return new ResponseEntity<BookingEvent>(bookingService,HttpStatus.OK);
	}
	
	@DeleteMapping("deleteBookingById/{id}")
	public ResponseEntity<String> deleteBookingById(@PathVariable int id)
	{
		bookingEventService.deleteBookingById(id);
		return new ResponseEntity<String>("Event Deleted Successfully!!",HttpStatus.OK);
	}
	
	//update booking status by organizer
	@PutMapping("/updateBookingStatus/{id}")
	public ResponseEntity<String> updateBookingStatus(@PathVariable int id, @RequestBody BookingEvent bookingEvent)
	{
		bookingEventService.updateBookingStatus(id,bookingEvent);
		return new ResponseEntity<String>("Update booking status Successfully",HttpStatus.CREATED);
	}
	
	//update booking status by user
	@PutMapping("/updateUserStatus/{id}")
	public ResponseEntity<String> updateUserStatus(@PathVariable int id, @RequestBody BookingEvent bookingEvent)
	{
		bookingEventService.updateUserStatus(id,bookingEvent);
		return new ResponseEntity<String>("Updated booking status by user Successfully",HttpStatus.CREATED);
	}
		
	//get booking history List by user id
	@GetMapping("/bookingHistoryByUserId/{id}")
	public ResponseEntity<List<BookingEvent>> bookingHistoryByUserId(@PathVariable int id)
	{
		List<BookingEvent> eventList = bookingEventService.bookingHistoryByUserId(id);
		return new ResponseEntity<List<BookingEvent>>(eventList,HttpStatus.OK);
	}
	
	//get Event List by id
	@GetMapping("/getBookingHistoryByOrganizerId/{id}")
	public ResponseEntity<List<BookingEvent>> getBookingHistoryByOrganizerId(@PathVariable int id)
	{
		List<BookingEvent> eventList = bookingEventService.getBookingHistoryByOrganizerId(id);
		return new ResponseEntity<List<BookingEvent>>(eventList,HttpStatus.OK);
	}
}