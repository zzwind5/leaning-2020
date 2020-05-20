package com.jie.anno.com.jie.anno.config;

import com.jie.anno.aop.MathAspect;
import com.jie.anno.service.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MyConfigOfAop {

	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}

	@Bean
	public MathAspect mathAspect() {
		return new MathAspect();
	}
}
