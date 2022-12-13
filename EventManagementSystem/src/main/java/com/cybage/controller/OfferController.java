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
import com.cybage.model.OfferBean;
import com.cybage.service.OfferService;

@CrossOrigin("*")
@RestController
@RequestMapping("/offer")
public class OfferController {
	
	@Autowired
	private OfferService offerService;
	
	@PostMapping("/")
	public ResponseEntity<String> addOffer(@RequestBody OfferBean offerBean)
	{
		OfferBean offerBean1=offerService.addOffer(offerBean);
		return new ResponseEntity<String>("Offer added Successfully!",HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<OfferBean>> getAllOffers()
	{
		List<OfferBean> offerList = offerService.getAllOffers();
		return new ResponseEntity<List<OfferBean>>(offerList,HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OfferBean> getOfferById(@PathVariable int id)
	{
		OfferBean offerBean1 = offerService.getOfferById(id);
		return new ResponseEntity<OfferBean>(offerBean1,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOffer(@PathVariable int id,@RequestBody OfferBean offerBean)
	{
		offerService.deleteOffer(id);
		return new ResponseEntity<String>("Offer Deleted Successfully!",HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateOffer(@PathVariable int id,@RequestBody OfferBean offerbean)
	{
		offerService.updateOffer(id,offerbean);
		return new ResponseEntity<String>("Offer Updated Successfully!",HttpStatus.CREATED);
	}
	
	//get offer List by id
	@GetMapping("/getOfferByOrganizerId/{id}")
	public ResponseEntity<List<OfferBean>> getOfferByOrganizerId(@PathVariable int id)
	{
		List<OfferBean> eventList = offerService.getOfferByOrganizerId(id);
		return new ResponseEntity<List<OfferBean>>(eventList,HttpStatus.OK);
	}

}
