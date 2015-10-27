package hu.schonherz.training.service.impl;

import hu.schonherz.training.service.api.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {

	public static final String HELLO_WORLD = "Hello World!";

	public String sayHello() {
		return HELLO_WORLD;
	}

}
