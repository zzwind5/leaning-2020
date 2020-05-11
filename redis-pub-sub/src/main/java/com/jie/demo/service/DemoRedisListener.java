package com.jie.demo.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class DemoRedisListener implements MessageListener {

	@Override
	public void onMessage(Message message, byte[] bytes) {
		System.out.printf("接收到消息: %s, topic: %s \n", new String(message.getBody()), new String(bytes));
	}
}
