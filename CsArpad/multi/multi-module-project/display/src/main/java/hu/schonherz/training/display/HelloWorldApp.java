package hu.schonherz.training.display;

import hu.schonherz.training.service.api.HelloWorldService;
import hu.schonherz.training.service.impl.HelloWorldServiceImpl;

public class HelloWorldApp {

	public static void main(String[] args) {
		HelloWorldService service = new HelloWorldServiceImpl();
		String res = service.sayHello();
		System.out.println(res);
	}
}
