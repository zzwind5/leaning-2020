package com.jie.anno.test;

import com.jie.anno.com.jie.anno.config.ExtConfig;
import com.jie.anno.ext.MyBeanDefinitionRegistryPostProcessor;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExtConfigTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(ExtConfig.class);

		ioc.publishEvent(new ApplicationEvent(new String("我的测试事件")){});

		ioc.close();
	}
}
