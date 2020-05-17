package com.jie.anno.test;

import com.jie.anno.com.jie.anno.config.MyConfigLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @version 1.0
 * @author: Jie Zhang
 * @date: 2020/5/17 17:42
 */
public class BeanLifeCycleTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfigLifeCycle.class);

        System.out.println(ioc.getBean("car"));

//        Arrays.stream(ioc.getBeanDefinitionNames()).forEach(System.out::println);

        ioc.close();
    }
}
