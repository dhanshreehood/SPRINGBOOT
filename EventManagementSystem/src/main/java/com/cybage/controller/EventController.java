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

import com.cybage.model.EventBean;
import com.cybage.service.EventService;

@CrossOrigin("*")
@RestController
@RequestMapping("/event")

public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping("/")
	public ResponseEntity<String> addEvent(@RequestBody EventBean eventBean)
	{
		EventBean eventBean1 = eventService.addEvent(eventBean);
		return new ResponseEntity<String>("Event Added Successfully!!",HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EventBean>> getAllEvent()
	{
		List<EventBean> eventList = eventService.getAllEvent();
		return new ResponseEntity<List<EventBean>>(eventList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EventBean> getEventById(@PathVariable int id)
	{
		EventBean eventBean1 = eventService.getEventById(id);
		return new ResponseEntity<EventBean>(eventBean1,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable int id)
	{
		eventService.deleteEvent(id);
		return new ResponseEntity<String>("Event Deleted Successfully!!",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEvent(@PathVariable int id, @RequestBody EventBean eventBean)
	{
		eventService.updateEvent(id,eventBean);
		return new ResponseEntity<String>("Event Updated Successfully",HttpStatus.CREATED);
	}
	
	//sort price in descending
	@GetMapping("/priceFromDesc")
	public ResponseEntity<List<EventBean>> getAllEventPriceDESC()
	{
		List<EventBean> eventPriceInDesc = eventService.getAllEventPriceDESC();
		return new ResponseEntity<List<EventBean>>(eventPriceInDesc,HttpStatus.OK);
	}
	
	//sort price in ascending
	@GetMapping("/priceFromAsc")
	public ResponseEntity<List<EventBean>> getAllEventPriceASC()
	{
		List<EventBean> eventPriceInAsc = eventService.getAllEventPriceASC();
		return new ResponseEntity<List<EventBean>>(eventPriceInAsc,HttpStatus.OK);
	}
	
	//get Event List by id
	@GetMapping("/getEventListById/{id}")
	public ResponseEntity<List<EventBean>> getEventByOrganizerId(@PathVariable int id)
	{
		List<EventBean> eventList = eventService.getEventByOrganizerId(id);
		return new ResponseEntity<List<EventBean>>(eventList,HttpStatus.OK);
	}
	
}