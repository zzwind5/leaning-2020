package com.jie.anno.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@EventListener(classes = {ApplicationEvent.class})
	public void myListener(ApplicationEvent event) {
		System.out.println("UserService 收到事件: " + event);
	}
}
