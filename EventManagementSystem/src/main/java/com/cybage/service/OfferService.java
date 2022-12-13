package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.EventBean;
import com.cybage.model.OfferBean;
import com.cybage.repository.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	public OfferBean addOffer(OfferBean offerBean)
	{
		return offerRepository.save(offerBean);
	}
	
	public List<OfferBean> getAllOffers()
	{
		return offerRepository.findAll();
	}
	
	public OfferBean getOfferById(int id)
	{
		return offerRepository.findById(id).orElse(null);
	}

	public void deleteOffer(int id)
	{
		offerRepository.deleteById(id);
	}

	public OfferBean updateOffer(int id, OfferBean offerbean) 
	{
		OfferBean offerBean1=offerRepository.findById(id).get();
		if(offerbean.getOfferName()!=null)
			offerBean1.setOfferName(offerbean.getOfferName());
		return offerRepository.save(offerBean1);		
	}
	
	//get offer list by id
	public List<OfferBean> getOfferByOrganizerId(int id){
		return offerRepository.getOfferByOrganizerId(id);
	}
}
