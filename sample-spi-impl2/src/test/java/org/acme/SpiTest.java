package org.acme;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpiTest {

	@Test
	public void testGreeter() {
		assertEquals("Hello", GreeterService.getService().sayHello());
	}
}
