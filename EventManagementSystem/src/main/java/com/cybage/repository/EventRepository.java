package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybage.model.EventBean;
import com.cybage.model.RegistrationBean;

@Repository
public interface EventRepository extends JpaRepository<EventBean, Integer> {	
	
	@Query(value = "select * from event where event_organizer_id = ?1 ",nativeQuery=true)
	public List<EventBean> getEventByOrganizerId(int id);
	
}