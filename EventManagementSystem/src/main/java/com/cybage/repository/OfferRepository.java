package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.model.EventBean;
import com.cybage.model.OfferBean;

@Repository
public interface OfferRepository extends JpaRepository<OfferBean,Integer>{
	
	OfferBean save(OfferBean offerBean);

	List<OfferBean> findAll();
	
//	select * from offer_table where event_organizer_id = 2;
	
//	view offer by organizer id
	@Query(value = "select * from offer_table where event_organizer_id = ?1 ",nativeQuery=true)
	public List<OfferBean> getOfferByOrganizerId(int id);

}
