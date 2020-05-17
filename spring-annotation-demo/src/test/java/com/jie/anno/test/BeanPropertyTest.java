package com.jie.anno.test;

import com.jie.anno.com.jie.anno.config.MyConfigOfProperty;
import com.jie.anno.com.jie.anno.entity.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPropertyTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfigOfProperty.class);

		Person person = ioc.getBean("person", Person.class);

		System.out.println(person);
		System.out.println(ioc.getEnvironment().getProperty("person.nickName"));
	}
}
