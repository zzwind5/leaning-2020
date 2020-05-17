package com.jie.anno.test;

import com.jie.anno.com.jie.anno.config.MyConfig;
import com.jie.anno.com.jie.anno.config.MyConfig2;
import com.jie.anno.com.jie.anno.entity.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class MainTest {

	private void printBeans(AnnotationConfigApplicationContext ioc) {
		System.out.println("容器中的beans.....");
		Arrays.stream(ioc.getBeanDefinitionNames())
				.forEach(System.out::println);
	}

	@Test
	public void test01() {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig.class);

		String[] beans = ioc.getBeanDefinitionNames();
		Arrays.stream(beans).forEach(System.out::println);
	}

	@Test
	public void test02() {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig2.class);
		System.out.println("IOC load finished.....");

		ioc.getBean("lisi", Person.class);
		ioc.getBean("lisi", Person.class);
		ioc.getBean("wangwu", Person.class);
		ioc.getBean("wangwu", Person.class);
	}

	@Test
	public void test03() {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig2.class);

		System.out.println(ioc.getEnvironment().getProperty("os.name"));

		Map<String, Person> persons = ioc.getBeansOfType(Person.class);
		System.out.println(persons);
		printBeans(ioc);

		System.out.println(ioc.getBean("colorFactoryBean").getClass());
		System.out.println(ioc.getBean("&colorFactoryBean").getClass());
	}
}
