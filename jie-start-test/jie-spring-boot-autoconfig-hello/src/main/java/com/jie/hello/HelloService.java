package com.jie.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloService {

	@Autowired
	HelloProperties helloProperties;


	public String sayHello(String name) {
		return String.format("%s %s %s", helloProperties.getPrefix(), name, helloProperties.getSuffix());
	}
}
