package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cab;
import com.repository.CabRepository;

	@Service
	public class CabService {

		@Autowired
		CabRepository cabRepository;
		
		public List<Cab> findAllCabs() {
			return cabRepository.findAll();
		}
		
		public String findCabByIdAsString(int cid) {
			Optional<Cab> result = cabRepository.findById(cid);
			if(result.isPresent()) {
				Cab c = result.get();
				return c.toString();
			}else {
				return "Cab not present";
			}
		}
		
		public Cab findCabByIdAsObject(int cid) {
			Optional<Cab> result = cabRepository.findById(cid);
			if(result.isPresent()) {
				Cab c = result.get();
				return c;
			}else {
				return null;
			}
		}
		
		public String storeCab(Cab cab) {
			Optional<Cab> result = cabRepository.findById(cab.getCid());
			if(result.isPresent()) {
				return "Cab id must be unique";
			}else {
				cabRepository.save(cab);
				return "Cab stored successfully";
			}
		}
		
		public String deleteCab(int cid) {
			Optional<Cab> result = cabRepository.findById(cid);
			if(result.isPresent()) {
				cabRepository.deleteById(cid);
				return "Cab deleted successfully";
			}else {
				return "Cab not present";
			}
		}
		
		public String updateCab(Cab cab) {
			Optional<Cab> result = cabRepository.findById(cab.getCid());
			if(result.isPresent()) {
				
				Cab c = result.get();
				c.setTypeOfCab(cab.getTypeOfCab());
				c.setCapacity(cab.getCapacity());
				c.setCompany(cab.getCompany());
				c.setFare(cab.getFare());
				
				
				Cab cc = cabRepository.saveAndFlush(c);
				System.out.println(cc);
				return "Cab details updated successfully";
			}else {
				return "Cab not present";
			}
		}
	
}
	
	
