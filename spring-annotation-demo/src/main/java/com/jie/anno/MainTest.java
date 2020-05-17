package com.jie.anno;

import com.jie.anno.com.jie.anno.config.MyConfig;
import com.jie.anno.com.jie.anno.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig.class);

		Person person = ioc.getBean("person", Person.class);
		System.out.println(person);
	}
}
