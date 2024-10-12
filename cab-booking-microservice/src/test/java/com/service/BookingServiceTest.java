package com.service;

    import static org.junit.jupiter.api.Assertions.*;
	import java.util.List;

	import org.junit.jupiter.api.Disabled;
	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

	import com.entity.Booking;

	@SpringBootTest
	class BookingServiceTest {

		@Autowired
		BookingService bookingService;
		
		@Test
		void testFindAllBookings() {
		List<Booking> listOfBooking	= bookingService.findAllBookings();
		assertNotNull(listOfBooking);	
		assertEquals(3, listOfBooking.size());
		Booking b = listOfBooking.get(0);
		assertEquals(1500, b.getAmount());
		assertEquals(1, b.getCid());
		assertEquals(5.6, b.getDistance());
		assertEquals("2pm", b.getTime());
		}

		@Test
		@Disabled
		void testStoreBooking() {
			Booking b = new Booking();
			b.setAmount(6000);
			b.setCid(2);
			b.setDistance(2);
			b.setTime("9am");
			String result1 = bookingService.storeBooking(b);
			assertEquals("Booking stored successfully", result1);
			String result2 = bookingService.storeBooking(b);
			assertEquals("Booking id must be unique", result2);
		}

	
}
