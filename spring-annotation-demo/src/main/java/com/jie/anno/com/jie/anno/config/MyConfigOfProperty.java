package com.jie.anno.com.jie.anno.config;

import com.jie.anno.com.jie.anno.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/person.properties")
@Configuration
public class MyConfigOfProperty {

	@Bean
	public Person person() {
		return new Person();
	}
}
