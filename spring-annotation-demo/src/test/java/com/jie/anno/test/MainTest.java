package com.jie.anno.test;

import com.jie.anno.com.jie.anno.config.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig.class);

		String[] beans = ioc.getBeanDefinitionNames();
		Arrays.stream(beans).forEach(System.out::println);
	}
}
