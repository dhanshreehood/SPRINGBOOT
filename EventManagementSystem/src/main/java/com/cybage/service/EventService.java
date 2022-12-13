package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cybage.model.AdminBean;
import com.cybage.model.EventBean;
import com.cybage.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	public EventBean addEvent(EventBean eventBean) 
	{
		return eventRepository.save(eventBean);
	}
	
	public List<EventBean> getAllEvent()
	{
		return eventRepository.findAll();	
	}
	
	public EventBean getEventById(int id)
	{
		return eventRepository.findById(id).orElse(null);
	}
	
	public void deleteEvent(int id)
	{
		eventRepository.deleteById(id);
	}
	
	public EventBean updateEvent(int id, EventBean eventBean)
	{
		EventBean eventBean1 = eventRepository.findById(id).get();
			if(eventBean.getEventName()!=null)
				eventBean1.setEventName(eventBean.getEventName());
			
//			if(eventBean.getEventCategory()!=null)
//				eventBean1.setEventCategory(eventBean.getEventCategory());
			
			if(eventBean.getEventDate()!=null)
				eventBean1.setEventDate(eventBean.getEventDate());
			
			if(eventBean.getEventDescription()!=null)
				eventBean1.setEventDescription(eventBean.getEventDescription());
			
			if(eventBean.getEventLocation()!=null)
				eventBean1.setEventLocation(eventBean.getEventLocation());
			
			if(eventBean.getEventPrice()!=0)
				eventBean1.setEventPrice(eventBean.getEventPrice());
				
		return eventRepository.save(eventBean1);
	}
	
	
	//sort price in descending
	public List<EventBean> getAllEventPriceDESC()
	{
		return eventRepository.findAll(Sort.by(Direction.DESC,"eventPrice"));		
	}
	
	//sort price in Ascending
	public List<EventBean> getAllEventPriceASC()
	{
		return eventRepository.findAll(Sort.by(Direction.ASC,"eventPrice"));		
	}

	//get event list by id
	public List<EventBean> getEventByOrganizerId(int id){
		return eventRepository.getEventByOrganizerId(id);
	}
		
}