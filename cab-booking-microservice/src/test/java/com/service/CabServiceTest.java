package com.service;

import static org.junit.jupiter.api.Assertions.*;


	import java.util.List;

	import org.junit.jupiter.api.Disabled;
	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;

	import com.entity.Cab;

	@SpringBootTest
	class CabServiceTest {

		@Autowired
		CabService cabService;
		
		@Test
		void testFindAllCabs() {
		List<Cab> listOfCab	= cabService.findAllCabs();
		assertNotNull(listOfCab);		// memory of list must be there 
		assertEquals(3, listOfCab.size());
		Cab c = listOfCab.get(0);
		assertEquals("2 seater", c.getCapacity());
		assertEquals("tata", c.getCompany());
		assertEquals(500, c.getFare());
		assertEquals(1, c.getTypeOfCab());
		}

		@Test
		@Disabled
		void testStoreCab() {
			Cab c = new Cab();
			c.setCapacity("3 seater");
			c.setCompany("audi");
			c.setFare(4000);
			c.setTypeOfCab(4);
			String result1 = cabService.storeCab(c);
			assertEquals("Cab stored successfully", result1);
			String result2 = cabService.storeCab(c);
			assertEquals("Cab id must be unique", result2);
		}

	

}
