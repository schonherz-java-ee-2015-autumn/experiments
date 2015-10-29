package hu.schonherz.training.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloWorldServiceImplTest {

	@Test
	public void testSayHello() {
		HelloWorldServiceImpl helloWordServiceImpl = new HelloWorldServiceImpl();
		String res = helloWordServiceImpl.sayHello();
		assertEquals(HelloWorldServiceImpl.HELLO_WORLD, res);
	}

}
