package com.jie.anno.com.jie.anno.config;

import com.jie.anno.com.jie.anno.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jie.anno")
public class MyConfig {

	@Bean("pp1")
	public Person person() {
		return new Person("pp1", 19);
	}
}
