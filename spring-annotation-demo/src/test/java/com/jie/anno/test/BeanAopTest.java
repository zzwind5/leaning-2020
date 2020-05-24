package com.jie.anno.test;

import com.jie.anno.com.jie.anno.config.MyConfigOfAop;
import com.jie.anno.service.MathCalculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanAopTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfigOfAop.class);

		MathCalculator math = ioc.getBean(MathCalculator.class);
		math.div(1, 1);
	}
}
