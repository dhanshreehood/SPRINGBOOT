package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybage.model.BookingEvent;
import com.cybage.model.EventBean;

@Repository
public interface BookingEventRepository extends JpaRepository<BookingEvent, Integer>{	

//	select * from booking_event where user_id = 1;
	
	@Query(value = "select * from booking_event where user_id = ?1 ",nativeQuery=true)
	public List<BookingEvent> bookingHistoryByUserId(int id);

//	select * from booking_event where event_organizer_id = 2;
	
	@Query(value = "select * from booking_event where event_organizer_id = ?1 ",nativeQuery=true)
	public List<BookingEvent> getBookingHistoryByOrganizerId(int id);
}
