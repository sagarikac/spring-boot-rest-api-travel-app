package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cab;
import com.service.CabService;

@RestController
public class CabController {

	@Autowired
	CabService cabService;
	
	
	@RequestMapping(value = "find_cabs",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cab> findAllCabs() {
		return cabService.findAllCabs();
	}
	
	
	
	
	@RequestMapping(value = "find_cab_by_id/{id}",method = RequestMethod.GET)
	public String findCabById(@PathVariable("id") int cid) {
		return cabService.findCabByIdAsString(cid);
	}
	
	
	@RequestMapping(value = "find_cab_by_id_object/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Cab findCabByIdReturnProduct(@PathVariable("id") int cid) {
			return cabService.findCabByIdAsObject(cid);
	}

	
	@RequestMapping(value = "store_cab",method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeCab(@RequestBody Cab cab) {	// ready to receive 
		return cabService.storeCab(cab);
	}
	
	
	@RequestMapping(value = "update_cab_info",method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateCab(@RequestBody Cab cab) {	// ready to receive 
		System.out.println(cab);		// @RequestBody annotation is use to extract json data from body 
		return cabService.updateCab(cab);
	}
	
	
	
		@RequestMapping(value = "delete_cab/{cid}",method = RequestMethod.DELETE)
		public String deleteCab(@PathVariable("cid") int cid) {	 
			return cabService.deleteCab(cid);
		}
	
}