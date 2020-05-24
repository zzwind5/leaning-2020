package com.jie.anno.com.jie.anno.config;

import com.jie.anno.com.jie.anno.entity.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.jie.anno.ext")
@Configuration
public class ExtConfig {

	@Bean
	public Blue blue() {
		return new Blue();
	}
}
