package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Booking;
import com.repository.BookingRepository;


@Service
public class BookingService {


		@Autowired
		BookingRepository bookingRepository;
		
		public List<Booking> findAllBookings() {
			return bookingRepository.findAll();
		}
		
		public String findBookingByIdAsString(int bid) {
			Optional<Booking> result = bookingRepository.findById(bid);
			if(result.isPresent()) {
				Booking b = result.get();
				return b.toString();
			}else {
				return "Booking not present";
			}
		}
		
		public Booking findBookingByIdAsObject(int bid) {
			Optional<Booking> result = bookingRepository.findById(bid);
			if(result.isPresent()) {
				Booking b = result.get();
				return b;
			}else {
				return null;
			}
		}
		
		public String storeBooking(Booking booking) {
			Optional<Booking> result = bookingRepository.findById(booking.getBid());
			if(result.isPresent()) {
				return "Booking id must be unique";
			}else {
				bookingRepository.save(booking);
				return "Booking stored successfully";
			}
		}
		
		public String deleteBooking(int bid) {
			Optional<Booking> result = bookingRepository.findById(bid);
			if(result.isPresent()) {
				bookingRepository.deleteById(bid);
				return "Booking deleted successfully";
			}else {
				return "Booking not present";
			}
		}
		
		public String updateBooking(Booking booking) {
			Optional<Booking> result = bookingRepository.findById(booking.getBid());
			if(result.isPresent()) {
				Booking b = result.get();
				b.setAmount(booking.getAmount());
				b.setCid(booking.getCid());
				b.setDistance(booking.getDistance());
				b.setTime(booking.getTime());
				
				Booking bb = bookingRepository.saveAndFlush(b);
				System.out.println(bb);
				return "Booking details updated successfully";
			}else {
				return "Booking not present";
			}
		}
	
}

