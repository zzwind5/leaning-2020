package com.jie.anno.com.jie.anno.config;

import com.jie.anno.com.jie.anno.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public Person person() {
		return new Person("zhangsan", 19);
	}
}
