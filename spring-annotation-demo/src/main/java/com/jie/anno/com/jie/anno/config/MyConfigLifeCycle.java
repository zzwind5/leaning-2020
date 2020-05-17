package com.jie.anno.com.jie.anno.config;

import com.jie.anno.com.jie.anno.entity.Car;
import com.jie.anno.com.jie.anno.entity.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @version 1.0
 * @author: Jie Zhang
 * @date: 2020/5/17 17:41
 */
@ComponentScan(value="com.jie.anno",
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class))
@Configuration
public class MyConfigLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

    @Bean
    public Cat cat() {
        return new Cat();
    }
}
