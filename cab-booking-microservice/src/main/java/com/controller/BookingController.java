package com.controller;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.MediaType;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	import com.entity.Booking;
	import com.service.BookingService;

	@RestController
	public class BookingController {

		@Autowired
		BookingService bookingService;
		
		
		@RequestMapping(value = "find_bookings",method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Booking> findAllBookings() {
			return bookingService.findAllBookings();
		}
		
		
		
		
		@RequestMapping(value = "find_booking_by_id/{id}",method = RequestMethod.GET)
		public String findBookingById(@PathVariable("id") int bid) {
			return bookingService.findBookingByIdAsString(bid);
		}
		
		
		@RequestMapping(value = "find_booking_by_id_object/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public Booking findBookingByIdReturnProduct(@PathVariable("id") int bid) {
				return bookingService.findBookingByIdAsObject(bid);
		}

		
		@RequestMapping(value = "store_booking",method = RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE)
		public String storeBooking(@RequestBody Booking booking) {	// ready to receive 
			return bookingService.storeBooking(booking);
		}
		
		
		@RequestMapping(value = "update_booking_info",method = RequestMethod.PUT,
				consumes = MediaType.APPLICATION_JSON_VALUE)
		public String updateBooking(@RequestBody Booking booking) {	// ready to receive 
			System.out.println(booking);		// @RequestBody annotation is use to extract json data from body 
			return bookingService.updateBooking(booking);
		}
		
		
		
			@RequestMapping(value = "delete_booking/{bid}",method = RequestMethod.DELETE)
			public String deleteBooking(@PathVariable("bid") int bid) {	 
				return bookingService.deleteBooking(bid);
			}
		
	
}
